package Threads.level1;

public class StatesDemo {
    static final Object lock = new Object();

    static void pause(long ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public static void main(String[] args) {
        Thread sleeper = new Thread(() -> pause(1000), "sleeper");
        Thread holder  = new Thread(() -> { synchronized (lock) { pause(1000); } }, "holder");
        Thread blocked = new Thread(() -> { synchronized (lock) { } }, "blocked");
        Thread joiner  = new Thread(() -> {
            try { sleeper.join(); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }, "joiner");

        sleeper.start();
        holder.start();
        pause(100);
        blocked.start();
        joiner.start();
        pause(100);

        for (Thread t : new Thread[] {sleeper, holder, blocked, joiner}) {
            System.out.println(t.getName() + ": " + t.getState());
        }
    }
}