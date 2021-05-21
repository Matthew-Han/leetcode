package 动态规划;

/**
 * @ClassName LcOf10
 * @Description #剑指 Offer #10- I 斐波那契数列
 * @Author MatthewHan
 * @Date 2020/7/17 17:55
 * @Version 1.0
 **/
public class L10I {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int last = 0;
        int curr = 1;
        while (n > 1) {
            int next = curr + last;
            last = curr;
            curr = next % 1000000007;
            n--;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println("==========");
        System.out.println(fib(4));
        System.out.println("==========");
        System.out.println(fib(5));
    }
}
