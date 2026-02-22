package lab02;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionsDemo {
    private static final int NUM_THREADS = 5;
    private static final int NUM_ITEMS = 1000;

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        // Create and start producer threads
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread producerThread = new Thread(new Producer(concurrentHashMap, copyOnWriteArrayList));
            producerThread.start();
        }

        // Create and start consumer threads
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread consumerThread = new Thread(new Consumer(concurrentHashMap, copyOnWriteArrayList));
            consumerThread.start();
        }
    }

    static class Producer implements Runnable {
        private final ConcurrentHashMap<String, Integer> concurrentHashMap;
        private final CopyOnWriteArrayList<Integer> copyOnWriteArrayList;

        public Producer(ConcurrentHashMap<String, Integer> concurrentHashMap,
                CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
            this.concurrentHashMap = concurrentHashMap;
            this.copyOnWriteArrayList = copyOnWriteArrayList;
        }

        public void run() {
            for (int i = 0; i < NUM_ITEMS; i++) {
                String key = "Key" + i;
                int value = i;

                concurrentHashMap.put(key, value);
                copyOnWriteArrayList.add(value);

                System.out.println(Thread.currentThread().getName() + " produced item: " + value);
            }
        }
    }

    static class Consumer implements Runnable {
        private final ConcurrentHashMap<String, Integer> concurrentHashMap;
        private final CopyOnWriteArrayList<Integer> copyOnWriteArrayList;

        public Consumer(ConcurrentHashMap<String, Integer> concurrentHashMap,
                CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
            this.concurrentHashMap = concurrentHashMap;
            this.copyOnWriteArrayList = copyOnWriteArrayList;
        }

        public void run() {
            for (int i = 0; i < NUM_ITEMS; i++) {
                String key = "Key" + i;

                Integer valueFromMap = concurrentHashMap.get(key);
                Integer valueFromList = copyOnWriteArrayList.get(i);

                System.out.println(
                        Thread.currentThread().getName() + " consumed item from ConcurrentHashMap: " + valueFromMap);
                System.out.println(Thread.currentThread().getName() + " consumed item from CopyOnWriteArrayList: "
                        + valueFromList);
            }
        }
    }
}