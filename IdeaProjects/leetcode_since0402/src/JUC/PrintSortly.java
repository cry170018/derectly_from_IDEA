package JUC;

public class PrintSortly {
    //1114
    private volatile Object lock = new Object();//锁代码块需要自定一个对象作为锁，如果是syc修饰方法，则可以直接用this做锁
    private volatile boolean firstFinished = false;
    private volatile boolean secondFinished = false;

    //以上三个的volatile都不是必须的
    public PrintSortly() {

    }

    public void first() throws InterruptedException {

        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            System.out.println("first");
            firstFinished = true;

            lock.notifyAll();

        }

    }

    public void second() throws InterruptedException {
        synchronized (lock) {

            while (!firstFinished) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            System.out.println("second");
            secondFinished = true;
            lock.notifyAll();
        }

    }

    public void third() throws InterruptedException {
        synchronized (lock) {

            while (!secondFinished) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            System.out.println("third");

        }

    }


}


