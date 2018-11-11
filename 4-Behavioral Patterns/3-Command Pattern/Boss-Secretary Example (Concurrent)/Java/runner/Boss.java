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

import java.util.Queue;
import java.util.Random;

/**
 * Boss class that works as "Client" and actually uses Command Pattern.
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
     * Command queue shared by the "Invoker" and the "Client".
     * The "Client" will keep adding commands to this queue, and the "Invoker"
     * will keep fetching commands from this queue and execute them.
     */
    private final Queue<Command> tasks;

    /**
     * Constructor with parameter.
     * @param tasks command queue to add commands
     */
    private Boss(Queue<Command> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        Random randomGenerator = new Random();
        try {
            // For each command:
            // 1. Create a command and sets its receiver
            // 2. Add the command to the queue shared by the client and the invoker
            // 3. Wait for the invoker to fetch the command from the queue and executes it

            Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
            Command generateDailyReport = new GenerateDailyReport(reportGenerator);
            addTask(generateDailyReport);

            Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
            System.out.println();
            Command copyMyNameCard = new CopyDoc(printer, "Name Card of Boss");
            addTask(copyMyNameCard);

            Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
            System.out.println();
            Command printMySlides = new PrintDoc(printer, "My slides");
            addTask(printMySlides);

            Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
            System.out.println();
            Command emailSteve = new EmailSomeone(myEmailBox, "steverogers@gmail.com", "I need a plan of attack.");
            addTask(emailSteve);

            Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
            System.out.println();
            Command emailTony = new EmailSomeone(myEmailBox, "tonystark@gmail.com", "Any new tech today?");
            addTask(emailTony);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Private helper method to add the given command to the queue.
     * @param task command to add
     */
    private void addTask(Command task) {
        // Synchronize on the command queue shared by this boss and the secretary
        synchronized (tasks) {
            tasks.offer(task);
            System.out.println(task.getClass().getSimpleName() + " has been added to the task queue.");
            tasks.notifyAll();
        }
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Secretary secretary = new Secretary(); // Invoker
        Thread secretaryThread = new Thread(secretary);

        Boss boss = new Boss(secretary.tasks); // Client
        Thread bossThread = new Thread(boss);

        secretaryThread.start();
        bossThread.start();

        try {
            bossThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        secretary.stopThread();

        /*
         * Output:
         * A generate-daily-report command [Command] has been created.
         * GenerateDailyReport has been added to the task queue.
         * Secretary [Invoker] has fetched GenerateDailyReport from the task queue, and starts executing the command...
         * <Daily Report Generator> is generating a daily report:
         * **********
         * Sun Nov 11 11:48:58 PST 2018
         * **********
         *
         * A copy-document command [Command] has been created.
         * CopyDoc has been added to the task queue.
         * Secretary [Invoker] has fetched CopyDoc from the task queue, and starts executing the command...
         * <Printer> is copying Name Card of Boss
         *
         * A print-document command [Command] has been created.
         * PrintDoc has been added to the task queue.
         * Secretary [Invoker] has fetched PrintDoc from the task queue, and starts executing the command...
         * <Printer> is printing My slides
         *
         * An email-someone command [Command] has been created.
         * EmailSomeone has been added to the task queue.
         * Secretary [Invoker] has fetched EmailSomeone from the task queue, and starts executing the command...
         * <Email Box> is sending 'I need a plan of attack.' to steverogers@gmail.com
         *
         * An email-someone command [Command] has been created.
         * EmailSomeone has been added to the task queue.
         * Secretary [Invoker] has fetched EmailSomeone from the task queue, and starts executing the command...
         * <Email Box> is sending 'Any new tech today?' to tonystark@gmail.com
         */
    }

}
