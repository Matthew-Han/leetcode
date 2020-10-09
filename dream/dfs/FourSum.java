package dfs;

import java.util.*;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/10/9 05:39
 **/
public class FourSum {

    /**
     * #18 四数之和
     * 哇哇哇哇啊，优化到 282 / 283 还是超时，哭了。
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            List<Integer> list = new ArrayList<>(4);
            list.add(nums[i]);
            dfs(nums, target, i + 1, nums[i], res, list);
        }
        return res;

    }

    public void dfs(int[] nums, int target, int start, int sum, List<List<Integer>> res, List<Integer> next) {
        for (int i = start; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>(next);
            tmp.add(nums[i]);
            int currSum = sum + nums[i];
            if (tmp.size() < 4) {
                // 小剪枝
                if (currSum > 0 && currSum > target) {
                    return;
                    // 如果在小于4个元素的情况下出现了比target大的情况，判断后面还有负数吗？如果没有负数的话，直接return吧
                } else if (currSum < 0 && currSum > target && !check(nums, i, currSum, target)) {
                    return;
                } else {
                    dfs(nums, target, i + 1, currSum, res, tmp);
                }

            } else if (tmp.size() == 4) {
                if (currSum == target) {
                    Collections.sort(tmp);
                    if (!res.contains(tmp)) {
                        res.add(tmp);
                    }
                }
            }
        }
    }

    public boolean check(int[] nums, int start, int currSum, int target) {
        for (int i = start; i < nums.length; i++) {
            if (nums[start] < 0) {
                currSum += nums[start];
            }
            if (currSum <= target) {
                return true;
            }
            if (nums[start] > 0) {
                return false;
            }
        }
        return false;
    }
}
