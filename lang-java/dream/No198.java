/**
 * @ClassName HouseRobber
 * @Description #198 打家劫舍
 * @Author MatthewHan
 * @Date 2020/4/26 11:33
 * @Version 1.0
 **/
public class No198 {

    /**
     * 动态规划，官方题解
     * 我是傻逼
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37 MB , 在所有 Java 提交中击败了 6.52% 的用户
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{4, 2, 4, 9, 6}));
    }
}
