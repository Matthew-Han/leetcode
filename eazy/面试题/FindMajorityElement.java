package 面试题;

import java.util.Arrays;

/**
 * @ClassName FindMajorityElement
 * @Description 面试题 17.10. 主要元素
 * @Author MatthewHan
 * @Date 2020/7/29 11:20
 * @Version 1.0
 **/
public class FindMajorityElement {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 70.49% 的用户
     * 内存消耗： 43 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int m = -1;
        int len = nums.length;
        // 偶数
        if ((len & 1) == 0) {
            if (nums[len / 2 - 1] == nums[len / 2]) {
                m = nums[len / 2];
            }

        } else {
            // 奇数
            if (nums[0] == nums[len / 2] || nums[len / 2] == nums[len - 1]) {
                m = nums[len / 2];
            }
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 3, 3, 1}));
    }

}
