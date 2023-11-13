package 排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 排列组合.Subsets
 * @Description #78 子集
 * @Author MatthewHan
 * @Date 2020/8/12 16:43
 * @Version 1.0
 **/
public class No78 {

    /**
     * 逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.21% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 69.75% 的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> good = new ArrayList<>(res.get(j));
                good.add(num);
                res.add(good);
            }
        }
        return res;
    }

    /**
     * 递归拉胯
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.21% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 13.73% 的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res);
        return res;

    }

    public static void dfs(int[] nums, int index, List<List<Integer>> res) {
        if (index > nums.length - 1) {
            return;
        }
        int size = res.size();
        for (int i = 0; i < size; i++) {
            List<Integer> newList = new ArrayList<>(res.get(i));
            newList.add(nums[index]);
            res.add(newList);
        }
        List<Integer> curr = new ArrayList<>();
        curr.add(nums[index]);
        res.add(curr);
        index++;
        dfs(nums, index, res);
    }


}
