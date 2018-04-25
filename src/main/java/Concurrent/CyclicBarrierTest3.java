package Concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest3 {
    public static void main(String[] args) {

        CyclicBarrier c = new CyclicBarrier(2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {

                }
            }
        });
        thread.start();
        thread.interrupt();
        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }
    }
}
