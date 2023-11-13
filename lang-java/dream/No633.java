/**
 * @ClassName SumOfSquareNumbers
 * @Description #633 平方数之和
 * @Author MatthewHan
 * @Date 2020/5/22 21:27
 * @Version 1.0
 **/
public class No633 {


    /**
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 12.20% 的用户
     * 内存消耗 : 36.1 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        System.out.println(max);
        if (max * max == c) {
            return true;
        }
        int min = 1;
        while (min <= max) {
            System.out.println("min = " + min);
            System.out.println("max = " + max);
            if (Math.pow(min, 2) + Math.pow(max, 2) == c) {
                return true;
            }
            if (Math.pow(min, 2) + Math.pow(max, 2) > c) {
                max--;
            }
            min++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2020));
    }
}
