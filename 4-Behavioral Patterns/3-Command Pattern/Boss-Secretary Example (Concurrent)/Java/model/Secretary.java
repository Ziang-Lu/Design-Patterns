package model;

import model.command.Command;
import runner.Boss;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Secretary class that works as "Invoker".
 * This class is responsible for executing the different "Command"s.
 * The "Invoker" does not know how to handle the request, but simply invoke
 * command.execute() method, and let the internal correct "Receive" handle the
 * request.
 *
 * @author Ziang Lu
 */
public class Secretary implements Runnable {

    /**
     * Command priority queue (PQ) shared by the "Invoker" and the "Client".
     * The "Client" will keep adding commands to this PQ, and the "Invoker" will
     * keep fetching commands from this PQ and execute them.
     */
    private final BlockingQueue<Command> tasks;

    /**
     * Constructor with parameter.
     * @param tasks shared command PQ
     */
    public Secretary(BlockingQueue<Command> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Command task = tasks.take();
                // Check for the special command to shut down the secretary thread
                if (task.getClass().getSimpleName().equals("Shutdown")) {
                    break;
                }
                System.out.println(
                        Thread.currentThread().getName() + " Secretary [Invoker] has fetched " +
                                task.getClass().getSimpleName() +
                                " [Command] from the task priority queue, and starts executing the command..."
                );
                task.execute();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
