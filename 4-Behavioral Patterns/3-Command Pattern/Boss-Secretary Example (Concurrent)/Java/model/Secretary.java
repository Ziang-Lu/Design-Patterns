package model;

import model.command.Command;

import java.util.ArrayDeque;
import java.util.Queue;

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
     * Command queue shared by the "Invoker" and the "Client".
     * The "Client" will keep adding commands to this queue, and the "Invoker"
     * will keep fetching commands from this queue and execute them.
     */
    public final Queue<Command> tasks = new ArrayDeque<>();
    /**
     * Whether to stop this secretary thread.
     */
    private boolean stopThread = false;

    /**
     * Stops the secretary thread.
     */
    public void stopThread() {
        stopThread = true;
    }

    @Override
    public void run() {
        while (!stopThread) {
            // Synchronize on the command queue shared by this boss and the secretary
            synchronized (tasks) {
                while (tasks.isEmpty()) {
                    try {
                        // Wait for a new command to be added to the queue
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Fetch a command from the queue, and execute it
                Command task = tasks.poll();
                System.out.println("Secretary [Invoker] has fetched " + task.getClass().getSimpleName() +
                        " from the task queue, and starts executing the command...");
                task.execute();
            }
        }
    }

}
