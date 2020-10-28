package test;

public class ThreadTest implements Runnable {

    private String name;
    private Object self;
    private Object prev;

    public ThreadTest(String name, Object self, Object prev) {
        this.name = name;
        this.self = self;
        this.prev = prev;
    }

    @Override
    public void run() {
        int count = 2;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.println(name);
                    count--;
                    try {
                        self.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        new Thread(new ThreadTest("A", a, c)).start();
        new Thread().sleep(10);
        new Thread(new ThreadTest("B", b, a)).start();
        new Thread().sleep(10);
        new Thread(new ThreadTest("C", c, b)).start();

    }
}
