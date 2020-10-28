package test;

public class test2 {
    private int num;
    private Object lock = new Object();
    private static int staticNum;

    public void add() {
        synchronized (lock) {
            num++;
        }
    }

    public synchronized void plus() {
        num++;
    }

    public static synchronized void staticPlus() {
        staticNum++;
    }

    public static void main(String[] args) {

    }
}
