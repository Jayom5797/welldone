// DiningPhilosophers.java
// Classic Dining Philosophers Problem using threads and semaphores
import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    static class Philosopher extends Thread {
        private int id;
        private Semaphore leftFork;
        private Semaphore rightFork;

        public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        public void run() {
            try {
                while (true) {
                    System.out.println("Philosopher " + id + " is thinking.");
                    Thread.sleep((int)(Math.random() * 100));
                    leftFork.acquire();
                    rightFork.acquire();
                    System.out.println("Philosopher " + id + " is eating.");
                    Thread.sleep((int)(Math.random() * 100));
                    leftFork.release();
                    rightFork.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Semaphore[] forks = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            forks[i] = new Semaphore(1);
        }
        Philosopher[] philosophers = new Philosopher[n];
        for (int i = 0; i < n; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i+1)%n]);
            philosophers[i].start();
        }
    }
}