package Concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock readLock = lock.readLock();
    static Lock writeLock = lock.writeLock();

    public static final Object get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public static final Object put(String key, Object o) {
        writeLock.lock();
        try {
            return map.put(key, o);
        } finally {
            writeLock.unlock();
        }
    }

    public static final void clear() {
        writeLock.unlock();
        try {
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }
}
