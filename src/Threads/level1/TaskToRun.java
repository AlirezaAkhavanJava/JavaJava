package Threads.level1;

public class TaskToRun extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i < 50) {
            ++i;
            System.out.println("THREAD RUNNING " + Thread.currentThread().getName());
        }
    }
}
