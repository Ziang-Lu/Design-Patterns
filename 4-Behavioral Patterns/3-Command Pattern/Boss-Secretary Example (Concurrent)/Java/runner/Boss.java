package runner;

import model.Secretary;
import model.command.Command;
import model.command.CopyDoc;
import model.command.EmailSomeone;
import model.command.GenerateDailyReport;
import model.command.PrintDoc;
import model.receiver.DailyReportGenerator;
import model.receiver.EmailBox;
import model.receiver.Printer;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Boss class that works as "Client" and actually uses Command Pattern.
 *
 * Note that we could have some more variants, such as:
 * Create multiple threads:
 * - Separately but concurrently add commands to the command priority queue
 * - Separately but concurrently fetch command from the command priority queue,
 *   and then execute it
 *
 * @author Ziang Lu
 */
public class Boss implements Runnable {

    /**
     * Email box of this boss.
     */
    private EmailBox myEmailBox = EmailBox.getInstance(); // Receiver
    /**
     * Report generator of the company.
     */
    private DailyReportGenerator reportGenerator = DailyReportGenerator.getInstance(); // Receiver
    /**
     * A printer of the company.
     */
    private Printer printer = new Printer(); // Receiver
    /**
     * Command priority queue (PQ) shared by the "Invoker" and the "Client".
     * The "Client" will keep adding commands to this PQ, and the "Invoker"
     * will keep fetching commands from this PQ and execute them.
     */
    private final PriorityQueue<Command> tasks = new PriorityQueue<>();
    /**
     * Whether this boss has finished assigning all the tasks.
     */
    private boolean finishedAssignTasks = false;

    /**
     * Accessor of finishedAssignTasks.
     * @return whether this boss has finished assigning tasks
     */
    public boolean hasFinishedAssignTasks() {
        return finishedAssignTasks;
    }

    @Override
    public void run() {
        Random randomGenerator = new Random();
        try {
            // For each command:
            // 1. Create a command and sets its receiver
            // 2. Add the command to the PQ shared by the client and the invoker
            // 3. Wait for the invoker to fetch the command from the PQ and executes it

            Command generateDailyReport = new GenerateDailyReport(reportGenerator, 5);
            addTask(generateDailyReport);

            Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
            Command copyMyNameCard = new CopyDoc(printer, "Name Card of Boss", 2);
            addTask(copyMyNameCard);

            Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
            Command printMySlides = new PrintDoc(printer, "My slides", 3);
            addTask(printMySlides);

            Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
            Command emailSteve = new EmailSomeone(myEmailBox, "steverogers@gmail.com", "I need a plan of attack.", 4);
            addTask(emailSteve);

            Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
            Command emailTony = new EmailSomeone(myEmailBox, "tonystark@gmail.com", "Any new tech today?", 2);
            addTask(emailTony);

            finishedAssignTasks = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Private helper method to add the given command to the PQ.
     * @param task command to add
     */
    private void addTask(Command task) {
        // Synchronize on the command PQ shared by this boss and the secretary
        synchronized (tasks) {
            tasks.offer(task);
            System.out.println(Thread.currentThread().getName() + " " + task.getClass().getSimpleName() +
                    " [Command] has been added to the task priority queue");
            tasks.notifyAll();
        }
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Boss boss = new Boss(); // Client
        Thread bossThread = new Thread(boss, "[Boss-Thread]");

        Secretary secretary = new Secretary(boss, boss.tasks); // Invoker
        Thread secretaryThread = new Thread(secretary, "[Secretary-Thread]");

        secretaryThread.start();
        bossThread.start();

        try {
            bossThread.join();
            secretaryThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * Output:
         * [Boss-Thread] A generate-daily-report command [Command] has been created
         * [Boss-Thread] GenerateDailyReport [Command] has been added to the task priority queue
         * [Secretary-Thread] Secretary [Invoker] has fetched GenerateDailyReport [Command] from the task priority queue, and starts executing the command...
         * [Secretary-Thread] <Daily Report Generator> is generating a daily report...
         * [Boss-Thread] A copy-document command [Command] has been created
         * [Boss-Thread] CopyDoc [Command] has been added to the task priority queue
         * ***** Daily Report *****
         * Mon Nov 12 17:47:36 PST 2018
         * ************************
         * [Secretary-Thread] Secretary [Invoker] has fetched CopyDoc [Command] from the task priority queue, and starts executing the command...
         * [Secretary-Thread] <Printer> has copied Name Card of Boss
         * [Boss-Thread] A print-document command [Command] has been created
         * [Boss-Thread] PrintDoc [Command] has been added to the task priority queue
         * [Secretary-Thread] Secretary [Invoker] has fetched PrintDoc [Command] from the task priority queue, and starts executing the command...
         * [Boss-Thread] An email-someone command [Command] has been created
         * [Secretary-Thread] <Printer> has printed My slides
         * [Boss-Thread] EmailSomeone [Command] has been added to the task priority queue
         * [Secretary-Thread] Secretary [Invoker] has fetched EmailSomeone [Command] from the task priority queue, and starts executing the command...
         * [Boss-Thread] An email-someone command [Command] has been created
         * [Boss-Thread] EmailSomeone [Command] has been added to the task priority queue
         * [Secretary-Thread] <Email Box> has sent 'I need a plan of attack.' to steverogers@gmail.com
         * [Secretary-Thread] Secretary [Invoker] has fetched EmailSomeone [Command] from the task priority queue, and starts executing the command...
         * [Secretary-Thread] <Email Box> has sent 'Any new tech today?' to tonystark@gmail.com
         */
    }

}
