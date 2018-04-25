package concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String a = "银行流水a";
                    exgr.exchange(a);
                } catch (Exception e) {
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String b = "银行流水b";
                    String a = exgr.exchange(b);
                    System.out.println(a.equals(b));
                    System.out.println(a);
                } catch (Exception e) {
                }
            }
        });

        threadPool.shutdown();
    }
}
