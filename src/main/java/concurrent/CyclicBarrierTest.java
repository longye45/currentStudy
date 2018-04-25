package concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);//屏障，等待俩个线程

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {

        }
        System.out.println(2);
    }
}
