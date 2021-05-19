/**
 * @ClassName PrintInOrder
 * @Description #1114 按序打印
 * @Author MatthewHan
 * @Date 2020/7/6 11:06
 * @Version 1.0
 **/
public class No1114 {

    volatile int step = 0;

    /**
     * 内存屏障
     */
    public No1114() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        while (true) {
            if (step == 0) {
                step++;
                printFirst.run();
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (true) {
            if (step == 1) {
                printSecond.run();
                step++;
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (true) {
            if (step == 2) {
                printThird.run();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        No1114 no1114 = new No1114();
        Runnable runnable1 = () -> System.out.println("first");
        Runnable runnable2 = () -> System.out.println("second");
        Runnable runnable3 = () -> System.out.println("third");
        no1114.second(runnable2);
        System.out.println("ssss");
        no1114.third(runnable3);
        no1114.first(runnable1);
    }
}
