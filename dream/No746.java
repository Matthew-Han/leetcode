/**
 * @ClassName MinCostClimbingStairs
 * @Description #746 使用最小花费爬楼梯
 * @Author MatthewHan
 * @Date 2020/6/6 01:01
 * @Version 1.0
 **/
public class No746 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.93% 的用户
     * 内存消耗 : 39.2 MB , 在所有 Java 提交中击败了 22.22% 的用户
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }


    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 2, 2, 0}));
    }
}
