import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/14 15:09
 * @since 1.0
 **/
public class No470 {

    /**
     * 用 Rand7() 实现 Rand10()
     * <p>
     * 先用 (1 ~ 7) * (1 ~ 7) 得到一张表, 找到概率一样的 x 个数
     * 然后把这 x 个数表示成需要的数字, 因为 x 个他们出现的概率是相同的!
     * 如果没有得到这些数字就继续随机好了!
     *
     * @return
     */
    public static int rand10() {
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 8, 10, 14, 15, 20, 21));
        while (true) {
            int r = rand7() * rand7();
            if (set.contains(r)) {
                if (r == 2) {
                    return 1;
                } else if (r == 3) {
                    return 2;
                } else if (r == 5) {
                    return 3;
                } else if (r == 7) {
                    return 4;
                } else if (r == 8) {
                    return 5;
                } else if (r == 10) {
                    return 6;
                } else if (r == 14) {
                    return 7;
                } else if (r == 15) {
                    return 8;
                } else if (r == 20) {
                    return 9;
                } else if (r == 21) {
                    return 10;
                }
            }
        }
    }

    public static int rand7() {
        return new Random().nextInt(7) + 1;
    }

    public static void main(String[] args) {
        int[] bucket = new int[11];
        for (int i = 0; i < 10000; i++) {
            bucket[rand10()]++;
        }
        System.out.println("bucket = " + Arrays.toString(bucket));
    }
}
