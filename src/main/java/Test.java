import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public volatile int inc = 0;
    public AtomicInteger atomicInteger = new AtomicInteger();

    public void increase() {
        while (!cas(inc, inc + 1)) {
        }
    }

    public boolean cas(int current, int value) {
        return atomicInteger.compareAndSet(current, value);
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}