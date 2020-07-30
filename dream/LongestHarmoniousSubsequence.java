import java.util.*;

/**
 * @ClassName LongestHarmoniousSubsequence
 * @Description #594 最长和谐子序列
 * @Author MatthewHan
 * @Date 2020/5/21 10:10
 * @Version 1.0
 **/
public class LongestHarmoniousSubsequence {

    /**
     * 执行用时 : 1428 ms , 在所有 Java 提交中击败了 5.46% 的用户
     * 内存消耗 : 40.4 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param nums
     * @return
     */
    public static int findLHSPro(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            // 排序后比i指针元素大1的元素的累计
            int sum = 0;
            // 是否是存在至少一个比i指针元素大1的元素，这样才算OK
            boolean fucked = false;
            while (j < nums.length) {
                if (nums[j] - nums[i] == 1) {
                    sum++;
                    fucked = true;
                }
                if (nums[j] == nums[i]) {
                    sum++;
                }
                j++;
            }
            if (fucked) {
                max = Math.max(max, sum);
            }
        }
        return max == 0 ? max : max + 1;
    }

    /**
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public static int findLHS(int[] nums) {

        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>(nums.length * 4 / 3 + 1);
        Set<Integer> set2 = new HashSet<>(nums.length * 4 / 3 + 1);
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() == 1) {
            return 0;
        }
        int max = 0;
        for (Integer ele : set) {
            int currSum = 0;
            for (int num : nums) {
                if (num == ele || num - ele == 1) {
                    set2.add(num);
                    currSum++;
                }
            }
            if (set2.size() > 1) {
                max = Math.max(currSum, max);
            }
            set2.clear();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLHSPro(new int[]{1, 4, 1, 3, 1, -14, 1, -13}));
        System.out.println(findLHSPro(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17}));
        System.out.println(findLHSPro(new int[]{1, 1, 1, 1}));
        System.out.println(findLHSPro(new int[]{1, 1, 1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println(findLHSPro(new int[]{2, 2, 3}));
    }

}
