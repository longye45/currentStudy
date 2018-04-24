public class JoinCountDownLatchTest {
    public static void main(String[] args) throws Exception {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("over1");
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("over2");
            }
        });
        parser1.start();
        parser2.start();

        parser1.join();
        parser1.join();

        System.out.println("all over");
    }
}
