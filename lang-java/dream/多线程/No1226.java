package 多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/12/17 15:32
 * @since 1.0
 **/
public class No1226 {

    ReentrantLock lock;
    Condition[] conditions;

    int number;

    /**
     *
     */
    public No1226() {
        this.lock = new ReentrantLock();
        this.conditions = new Condition[5];
        this.number = 0;
        for (int i = 0; i < conditions.length; i++) {
            conditions[i] = lock.newCondition();
        }

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        lock.lock();
        try {
            while (philosopher != number) {
                conditions[philosopher].await();
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();

            number++;
            number %= 5;
            conditions[number].signal();
        } finally {
            lock.unlock();
        }


    }

    public static class Fuck implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        No1226 demo = new No1226();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int j = 0; j < 2; j++) {


            for (int i = 0; i < 5; i++) {
                int ii = i;
                executorService.execute(() -> {

                    try {
                        demo.wantsToEat(ii, new Fuck(), new Fuck(), new Fuck(), new Fuck(), new Fuck());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                });
            }
        }
    }
}
