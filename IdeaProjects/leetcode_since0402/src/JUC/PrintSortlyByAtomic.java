package JUC;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintSortlyByAtomic {
    //1114

    private final AtomicInteger atomic = new AtomicInteger(0);

    public PrintSortlyByAtomic() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        atomic.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (atomic.get() != 1) {
        }
        printSecond.run();
        atomic.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (atomic.get() != 2) {
        }
        printThird.run();
    }

}
