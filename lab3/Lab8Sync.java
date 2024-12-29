public class Lab8Sync {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        int n = 2;
        int m = 2;
        int iterations = 100_000;

        Thread[] incrementThreads = new Thread[n];
        Thread[] decrementThreads = new Thread[m];

        Object lock = new Object(); // Используется для синхронизации

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            incrementThreads[i] = new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    synchronized (lock) {
                        counter++;
                    }
                }
            });
        }

        for (int i = 0; i < m; i++) {
            decrementThreads[i] = new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    synchronized (lock) {
                        counter--;
                    }
                }
            });
        }

        for (Thread thread : incrementThreads) thread.start();
        for (Thread thread : decrementThreads) thread.start();

        for (Thread thread : incrementThreads) thread.join();
        for (Thread thread : decrementThreads) thread.join();

        long endTime = System.nanoTime();

        System.out.println("Final Counter: " + counter);
        System.out.println("Execution Time (ms): " + (endTime - startTime) / 1_000_000);
    }
}
