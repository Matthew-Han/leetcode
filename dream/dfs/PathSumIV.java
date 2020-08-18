package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PathSumIV
 * @Description #666 路径和 IV
 * @Author MatthewHan
 * @Date 2020/8/18 11:00
 * @Version 1.0
 **/
public class PathSumIV {
    /**
     * 递归一把梭，模拟二叉树dfs就可以了，比单纯的二叉树结构复杂的地方就是对depth和子树的拿取。
     * <p>
     * 1. 每次dfs，depth只要除以100就可以得到，所以子树的depth就是 + 1；
     * 2. 因为只有4层，所以子树的判断也简单的（第二位），取余就可以了；
     * 3. 设立一个index指针，每次dfs + 1，用于指代prev父节点；
     * 4. 递归的终止条件，当for循环没有可以找得到的子树了。
     *
     * @param nums
     * @return
     */
    public static int pathSum(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        tmp.add(nums[0]);
        dfs(nums, 0, tmp, res);
        int sum = 0;
        for (List<Integer> list : res) {
            for (Integer n : list) {
                sum += n % 10;
            }
        }
        return sum;

    }

    /**
     * @param nums
     * @param index
     * @param list
     * @param res
     */
    public static void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        int curr = list.get(index);
        boolean flag = false;
        for (int num : nums) {
            if (num / 100 == curr / 100 + 1 && check(curr, num)) {
                flag = true;
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(num);
                dfs(nums, index + 1, tmp, res);
            }
        }
        if (!flag) {
            res.add(list);
        }
    }

    public static boolean check(int root, int sub) {
        // 求第二位
        root /= 10;
        sub /= 10;
        // 取余
        root %= 10;
        sub %= 10;
        if (root == 1 && (sub == 1 || sub == 2)) {
            return true;
        } else if (root == 2 && (sub == 3 || sub == 4)) {
            return true;
        } else if (root == 3 && (sub == 5 || sub == 6)) {
            return true;
        } else {
            return root == 4 && (sub == 7 || sub == 8);
        }
    }
}
