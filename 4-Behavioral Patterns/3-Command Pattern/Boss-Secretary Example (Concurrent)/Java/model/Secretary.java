package model;

import model.command.Command;

import java.util.PriorityQueue;

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
    public final PriorityQueue<Command> tasks = new PriorityQueue<>();

    @Override
    public void run() {
        while (true) {
            Command task = null;
            // Synchronize on the command PQ shared by this boss and the secretary
            synchronized (tasks) {
                while (tasks.isEmpty()) {
                    try {
                        // Wait for a new command to be added to the PQ
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Fetch a command from the PQ, and execute it
                task = tasks.poll();
                System.out.println(
                        Thread.currentThread().getName() + " Secretary [Invoker] has fetched " +
                                task.getClass().getSimpleName() +
                                " [Command] from the task priority queue, and starts executing the command..."
                );
            }
            task.execute();
        }
    }

}
