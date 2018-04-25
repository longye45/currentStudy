package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

public class FutureTastTest {
    private final ConcurrentHashMap<Object, FutureTask<String>> taskCache = new ConcurrentHashMap<>();

    private String executionTask(final String taskName) {
        while (true) {
            FutureTask<String> futureTask = taskCache.get(taskName);
            if (futureTask == null) {
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() {
                        return taskName;
                    }
                };

                FutureTask<String> futureTask1 = new FutureTask<>(task);
                futureTask = taskCache.putIfAbsent(taskName, futureTask1);

                if (futureTask == null) {
                    futureTask = futureTask1;
                    futureTask.run();
                }
            }

            try {
                return futureTask.get();
            } catch (Exception e) {
                taskCache.remove(taskName, futureTask);
            }
        }
    }
}
