package Threads.Basic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDepo {
    private final AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

    public AtomicInteger getCount() {
        return count;
    }
}
