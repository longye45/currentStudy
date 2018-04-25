package concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {

    private static Lock fairlock = new ReentrantLock2(true);

    private static Lock unfairLock = new ReentrantLock2(false);

    public void fair() {
        testLock(fairlock);
    }

    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(Lock lock) {
        for (int i = 0; i < 5; i++) {
            new Job(lock).start();
        }
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("running:" + Thread.currentThread());
                List<Thread> threadList = (List<Thread>) ((ReentrantLock2) lock).getQueuedThreads();
                for (int j = 0; j < threadList.size(); j++) {
                    System.out.println("waitting:" + threadList.get(i));
                }
                lock.unlock();
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> list = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(list);
            return list;
        }
    }

}
