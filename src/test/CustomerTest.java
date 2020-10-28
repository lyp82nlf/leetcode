package test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {
    private final int MAX_SUM = 100;
    private List<Object> wareHouse = new ArrayList<>();

    private Runnable producer = new Runnable() {
        @Override
        public void run() {
            synchronized (wareHouse) {
                while (true) {
                    while (wareHouse.size() > MAX_SUM) {
                        System.out.println("仓库已满");
                        try {
                            wareHouse.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    wareHouse.add(new Object());
                    System.out.println("添加库存,当前库存" + wareHouse.size());
                    try {
                        new Thread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    wareHouse.notifyAll();
                }
            }
        }
    };

    private Runnable customer = new Runnable() {
        @Override
        public void run() {
            synchronized (wareHouse) {
                while (true) {
                    while (wareHouse.size() == 0) {
                        System.out.println("仓库已空");
                        try {
                            wareHouse.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    wareHouse.remove(0);
                    System.out.println("消费库存,当前库存" + wareHouse.size());
                    try {
                        new Thread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    wareHouse.notifyAll();
                }
            }
        }
    };

    public static void main(String[] args) {
       new CustomerTest().test();
    }

    public void test(){
        new Thread(new CustomerTest().producer).start();
        new Thread(new CustomerTest().producer).start();
        new Thread(new CustomerTest().producer).start();
        new Thread(new CustomerTest().producer).start();
        new Thread(new CustomerTest().producer).start();

        new Thread(new CustomerTest().customer).start();
        new Thread(new CustomerTest().customer).start();
        new Thread(new CustomerTest().customer).start();
    }
}
