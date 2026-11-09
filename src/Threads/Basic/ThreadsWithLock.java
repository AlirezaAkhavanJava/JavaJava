package Threads.Basic;

public class ThreadsWithLock {

    public static void beganReent() throws InterruptedException {
        ReentLockedDepo reentLockedDepo = new ReentLockedDepo();
        Runnable rb = () -> {
            int i = 0;
            while (i < 100_000) {
                reentLockedDepo.increment();
                i++;
                System.out.println(Thread.currentThread().getName() + " " + reentLockedDepo.getCount());
            }
        };
        Thread thread1 = new Thread(rb);
        Thread thread2 = new Thread(rb);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(reentLockedDepo.getCount());
    }
}
