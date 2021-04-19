public class Inkrementierer implements Runnable {
    private Zähler counter;

    public Inkrementierer(Zähler counter) {
        this.counter = counter;
    }

    protected Thread[] getFourThreads(Runnable task) {
        var threads = new Thread[4];
        for (int i=0; i < 4; i++)
            threads[i] = new Thread(task);
        return threads;
    }

    public void syncIncrement() {
        Runnable increment = () -> counter.inkrementiereCounter();
        Thread[] threads;
        while (this.counter.counter < 1000) {
            threads = this.getFourThreads(increment);
            for (Thread thread: threads)
                thread.start();
            try {
                for (Thread thread: threads)
                    thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void asyncIncrement() {
        Runnable increment = () -> counter.inkrementiereCounter();
        Thread[] threads;
        while (this.counter.counter < 1000) {
            threads = this.getFourThreads(increment);
            for (Thread thread: threads)
                thread.start();
        }
    }

    @Override
    public void run() {}
}
