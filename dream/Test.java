/**
 * @ClassName Test
 * @Description 我要OFFER!!!
 * @Author MatthewHan
 * @Date 2020/9/7 17:14
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {

        System.out.println(0xA<<2);
        // new 出一个新的对象 t
        ThreadFuck t1 = new ThreadFuck();
        ThreadFuck t2 = new ThreadFuck();
        // 两个线程
        Thread thread1 = new Thread(t1, "Thread-1");
        Thread thread2 = new Thread(t2, "Thread-2");
        thread1.start();
        thread2.start();
        //t1.run();
        //t2.run();
    }

}

class ThreadFuck implements Runnable {

    int temp = 10;

    // private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        // lock.lock();
        for (int i = 0; i < 5; i++) {
            temp -= 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName() + "-temp = " + temp);
        }
        // lock.unlock();
    }
}
