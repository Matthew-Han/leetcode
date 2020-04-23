package leetcode.eazy;

/**
 * @ClassName ClimbingStairs
 * @Description #70 爬楼梯
 * @Author MatthewHan
 * @Date 2020/4/15 16:35
 * @Version 1.0
 **/
public class ClimbingStairs {

    /**
     * 1
     * 2
     * 3
     * 5
     * 8
     * 13
     * 21
     * 列出前几项，发现是斐波那契数列，第n项 = 前两项的和
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.2 MB , 在所有 Java 提交中击败了 5.66% 的用户
     * @param n
     * @return
     */
    public static int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int fuck = 0;
        for (int i = 2; i < n; i++) {
            fuck = first + second;
            first = second;
            second = fuck;
        }
        return fuck;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
