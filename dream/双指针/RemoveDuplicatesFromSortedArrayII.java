package 双指针;

/**
 * @ClassName RemoveDuplicatesFromSortedArrayII
 * @Description #80 删除排序数组中的重复项 II
 * @Author MatthewHan
 * @Date 2020/8/10 10:19
 * @Version 1.0
 **/
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 11.27% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 45.11% 的用户
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int i = 1;
        int prev = nums[0];
        int currCount = 1;
        int len = nums.length;
        while (i < len) {
            if (nums[i] == prev) {
                currCount++;
            } else {
                prev = nums[i];
                currCount = 1;
            }
            if (currCount > 2) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
                if (prev != nums[i]) {
                    prev = nums[i];
                    currCount = 1;
                } else {
                    // 这样的话还是3个，所以需要再来一轮
                    i--;
                }
            }
            i++;
        }
        return len;
    }

}
