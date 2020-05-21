/**
 * @ClassName ShortestUnsortedContinuousSubarray
 * @Description #581 最短无序连续子数组
 * @Author MatthewHan
 * @Date 2020/5/21 09:38
 * @Version 1.0
 **/
public class ShortestUnsortedContinuousSubarray {

    /**
     * 从左到右循环，记录最大值为 max，若 nums[i] < max, 则表明位置 i 需要调整, 循环结束，记录需要调整的最大位置 i 为 high;
     * 同理，从右到左循环，记录最小值为 min, 若 nums[i] > min, 则表明位置 i 需要调整，循环结束，记录需要调整的最小位置 i 为 low.
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 88.55% 的用户
     * 内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 19.05% 的用户
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int high = 0, low = len - 1, max = nums[0], min = nums[len - 1];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - 1 - i]);
            if (nums[i] < max) {
                high = i;
            }
            if (nums[len - 1 - i] > min) {
                low = len - 1 - i;
            }
        }
        return high > low ? high - low + 1 : 0;

    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1, 5, 7, 2, 6, 3, 7, 5, 2, 6, 0, 25}));
    }
}
