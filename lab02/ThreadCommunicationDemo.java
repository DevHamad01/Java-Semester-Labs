package lab02;

public class ThreadCommunicationDemo {
    private static final int MAX_CAPACITY = 5;
    private static final Object lock = new Object();
    private static int[] buffer = new int[MAX_CAPACITY];
    private static int count = 0;

    static class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < 5; i++) {
                produce(i);
            }
        }

        private void produce(int value) {
            synchronized (lock) {
                while (count == MAX_CAPACITY) {
                    try {
                        System.out.println("Buffer is full. Producer is waiting...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                buffer[count++] = value;
                System.out.println("Produced: " + value);
                lock.notify();
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i < 5; i++) {
                consume();
            }
        }

        private void consume() {
            synchronized (lock) {
                while (count == 0) {
                    try {
                        System.out.println("Buffer is empty. Consumer is waiting...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int value = buffer[--count];
                System.out.println("Consumed: " + value);
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }
}
