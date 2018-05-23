import java.util.Map;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Map map = Thread.getAllStackTraces();
        for (Object obj :
                map.keySet()) {
            System.out.println(obj.toString());
        }
        System.out.println(Thread.activeCount());
    }
}
