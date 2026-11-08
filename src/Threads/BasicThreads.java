package Threads;

import java.time.LocalTime;

public class BasicThreads {


    public static void began() throws Exception {
        Runnable task = () -> {
            int i = 0;
            while (i <= 1000) {
                i++;
                System.out.println("I like to see ");
                System.out.println("Thread name : " + Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(task, "Slave-1");
        Thread thread2 = new Thread(task, "Slave-2");
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("Done!");
    }

    public static void depoRunner() throws InterruptedException {
        Depo depo = new Depo();
        Runnable exc1 = () -> {
            long start = System.nanoTime();

            int i = 0;
            System.out.println(Thread.currentThread().getName());

            while (i < 100_000) {
                depo.increment();
                i++;
            }
            long end = System.nanoTime();
            long total = end - start;

            System.out.println("Execution time: " + total / 1_000_000.0 + " ms");
        };


        Thread exc1t = new Thread(exc1);
        Thread exc2t = new Thread(exc1);
        Thread exc3t = new Thread(exc1);

        exc1t.start();
        exc2t.start();
        exc3t.start();

        exc1t.join();
        exc2t.join();
        exc3t.join();
        System.out.println(depo.getCount());
    }

    public static void atomicCall() throws InterruptedException {
        AtomicDepo atomicDepo = new AtomicDepo();
        Runnable runnable = () -> {
            int i = 0;
            while (i < 100000) {
                atomicDepo.increment();
                System.out.println("count : " + atomicDepo.getCount() + " - " + Thread.currentThread().getName());
                i++;
            }

        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("COUNT : " + atomicDepo.getCount());
        System.out.println("DONE");

    }
}
