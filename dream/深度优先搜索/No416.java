package 深度优先搜索;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/24 17:29
 * @since 1.0
 **/
public class No416 {


    boolean flag;
    // 记忆化递归
    boolean[][] mem;

    /**
     * 分割等和子集
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        flag = false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        mem = new boolean[nums.length][sum + 1];
        Arrays.sort(nums);
        dfs(nums, sum, 0, 0);
        return flag;
    }

    public void dfs(int[] nums, int sum, int curr, int index) {
        if (flag) {
            return;
        }
        if (curr * 2 == sum) {
            flag = true;
            return;
        } else if (curr * 2 > sum) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (!mem[i][curr + nums[i]]) {
                mem[i][curr + nums[i]] = true;
                dfs(nums, sum, curr, i + 1);
                dfs(nums, sum, curr + nums[i], i + 1);
            }

        }
    }
}
