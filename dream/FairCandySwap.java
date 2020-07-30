import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName FairCandySwap
 * @Description #888 公平的糖果交换
 * @Author MatthewHan
 * @Date 2020/6/22 01:03
 * @Version 1.0
 **/
public class FairCandySwap {

    /**
     * 使用set后
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 93.25% 的用户
     * 内存消耗： 41.9 MB , 在所有 Java 提交中击败了 10.00% 的用户
     * <p>
     * 双for循环
     * 执行用时： 1212 ms , 在所有 Java 提交中击败了 9.11% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 30.00% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] fairCandySwap(int[] a, int[] b) {
        int sum1 = 0;
        for (int i : a) {
            sum1 += i;
        }

        int sum2 = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : b) {
            sum2 += i;
            set.add(i);
        }
        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);


        /*
         * 方法1：使用set集合
         */
        int diff = (sum1 - sum2) / 2;
        for (int element : a) {
            if (set.contains(element - (diff))) {
                return new int[]{element, element - diff};
            }
        }


        /*
         * 方法2：双for循环
         */
        if (sum1 > sum2) {
            diff = sum1 - sum2;
            for (int value : a) {
                for (int item : b) {
                    if (value - item == diff) {
                        return new int[]{value, item};
                    }
                }
            }
        }
        if (sum2 > sum1) {
            diff = sum2 - sum1;
            for (int item : b) {
                for (int value : a) {
                    if (item - value == diff) {
                        return new int[]{value, item};
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }

}
