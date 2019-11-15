# Thread Pool Pattern (线程池模式)

## Applicability

* When we need to create a large number of threads

  => Since creating a thread comes with a significant overhead, repeatedly creating and terminating threads individually would be too expensive operations, and thus decrease the performance.

  => Creating these large number of threads should be avoided

* At the same time, the time of the threads being used by the client is low.

<br>

## Definition & Explanation

This pattern is an application of <a href="https://github.com/Ziang-Lu/Design-Patterns/blob/master/2-Creational%20Patterns/5-Object%20Pool%20Pattern/Object%20Pool%20Pattern.md">Object Pool Pattern</a>.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/5-Concurrency%20Patterns/thread_pool_pattern_illustration.png?raw=true" width="500px">

*A thread pool is like having a number of workers (threads) in a factory (thread pool). We give these workers (threads) some tasks to work through, and we want that when a worker (thread) finishes a task, he/she immediately starts the next task.*

* Note that typically, there are more tasks than threads

<br>

## Code Example

```java
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Self-defined class that implements Runnable interface.
 *
 * @author Ziang Lu
 */
class Task implements Runnable {
    /**
     * Task ID.
     */
    private int id;
    /**
     * Random number generator to use.
     */
    private Random random;

    /**
     * Constructor with parameter.
     * @param id task ID
     */
    Task(int id) {
        this.id = id;
        random = new Random();
    }

    @Override
    public void run() {
        System.out.println("Starting task-" + id);
        // To simulate the task execution, sleep a random period between 1~5 seconds
        try {
            Thread.sleep((random.nextInt(4) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed task-" + id);
    }
}

/**
 * Simple demo for creating and using a thread pool.
 *
 * @author Ziang Lu
 */
public class ThreadPoolDemo {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService pool = Executors.newFixedThreadPool(3);
        // Submit tasks for execution
        for (int i = 0; i < 5; ++i) {
            pool.submit(new Task(i));
        }
        // We need to call shutdown() to indicate to the executor service (thread pool) that no more tasks are allowed
        // to be submitted.
        // If we don't call shutdown(), the program will never end, since the executor service (thread pool) keeps
        // waiting for more tasks to be submitted.
        pool.shutdown();
        // After calling shutdown(), no more tasks are allowed to be submitted; when all the submitted tasks finished
        // execution, this executor service (thread pool) is terminated.
        System.out.println("All tasks submitted and the executor service (thread pool) is shut down.");

        // Check: After calling shutdown(), submitting a new task throws a RejectedExecutionException
//        pool.submit(new Task(5));

        // Wait up to 60 seconds for all the submitted tasks to finish execution
        System.out.println("Waiting for all tasks to finish execution...");
        try {
            pool.awaitTermination(60, TimeUnit.SECONDS); // Block until all the submitted tasks finish execution
        } catch (InterruptedException e) {
            e.printStackTrace();
            pool.shutdownNow();
            // This will force the executor service (thread pool) to shut down and terminate, by attempting to stop the
            // executing tasks, and prevent waiting tasks from starting.
        }
        // Upon termination, the executor service has no tasks actively executing, no tasks currently awaiting
        // execution, and no new tasks are allowed to be submitted.
        System.out.println("All tasks completed.");

        /*
         * Output:
         * All tasks submitted and the executor service (thread pool) is shut down.
         * Waiting for all tasks to finish execution...
         * Starting task-2
         * Starting task-1
         * Starting task-0
         * Completed task-2
         * Completed task-0
         * Starting task-4
         * Starting task-3
         * Completed task-1
         * Completed task-3
         * Completed task-4
         * All tasks completed.
         */
    }

}
```

```python
import concurrent.futures as cf

import requests

sites = [
    'http://europe.wsj.com/',
    'http://www.bbc.co.uk/',
    'http://www.cnn.com/',
    'http://www.foxnews.com/',
]


def site_size(url: str) -> int:
    """
    Returns the page size in bytes of the given URL.
    :param url: str
    :return: str
    """
    response = requests.get(url)
    return len(response.content)


# Create a thread pool with 10 threads
with cf.ThreadPoolExecutor(max_workers=10) as pool:
    # Prepare Future objects to be executed
    future_to_url = {pool.submit(site_size, url): url for url in sites}
    # Execute each Future object and get the result
    for future in cf.as_completed(future_to_url.keys()):
        url = future_to_url[future]
        try:
            page_size = future.result()
        except Exception as e:
            print(f'{url} generated an exception: {e}')
        else:
            print(f'{url} page is {page_size} bytes.')

# Output:
# http://www.foxnews.com/ page is 216594 bytes.
# http://www.cnn.com/ page is 1725827 bytes.
# http://europe.wsj.com/ page is 979035 bytes.
# http://www.bbc.co.uk/ page is 289252 bytes.
```

<br>

## Benefit

Greatly avoids the repeated expensive thread creation process, and thus improves performance

