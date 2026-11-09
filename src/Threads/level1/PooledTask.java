package Threads.level1;

import java.util.concurrent.*;

public class PooledTask {
    public static void began() {
        try (ExecutorService pool = Executors.newCachedThreadPool()) {
            for (int i = 1; i <= 8010; i++) {
                int id = i;
                pool.submit(() -> System.out.println("Task " + id + " on " + Thread.currentThread().getName()));
            }
            pool.shutdown();
        }
    }

    public static void callWithFuture() {
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            Callable<Integer> callable = () -> {
                int s = 0;
                for (int i = 0; i <= 500; i++) {
                    s += i;
                    System.out.println(Thread.currentThread().getName());
                }
                return s;
            };

            Future<Integer> future = service.submit(callable);
            int result = future.get();
            System.out.println(result);
            service.shutdown();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
