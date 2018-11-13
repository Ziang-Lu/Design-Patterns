package model.command;

import model.receiver.DailyReportGenerator;

/**
 * Concrete GenerateDailyReport class that works as "ConcreteCommand".
 * This command generates a daily report using a report generator.
 *
 * This class contains a reference to a "Receiver", which is responsible for, in
 * the execute() method, perform some actions and thus handle the request.
 *
 * @author Ziang Lu
 */
public class GenerateDailyReport extends Command {

    /**
     * Reference to the "Receiver", which is responsible for, in th execute()
     * method, perform actions and thus handle the request.
     */
    private final DailyReportGenerator reportGenerator;

    /**
     * Constructor with parameter.
     * @param reportGenerator report generator to use
     * @param priority priority of the command
     */
    public GenerateDailyReport(DailyReportGenerator reportGenerator, int priority) {
        super(priority);
        this.reportGenerator = reportGenerator;
        System.out.println(Thread.currentThread().getName() + " A generate-daily-report command [Command] has been created");
    }

    @Override
    public void execute() {
        // Let the report generator [Receiver] handle this generate-daily-report command [Command]
        reportGenerator.generateDailyReport();
    }

}
