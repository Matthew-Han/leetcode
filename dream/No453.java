import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName MinimumMovesToEqualArrayElements
 * @Description #453 最小移动次数使数组元素相等
 * @Author MatthewHan
 * @Date 2020/5/15 14:19
 * @Version 1.0
 **/
public class No453 {

    /**
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        while (set.size() != 1) {
            set.clear();
            int[] maxElement = maxElement(nums);
            System.out.println(Arrays.toString(nums));
            // 将除了最大元素下标的其他的元素都+1（模拟移动）
            for (int i1 = 0; i1 < nums.length; i1++) {
                if (i1 != maxElement[1]) {
                    nums[i1]++;
                }
            }
            for (int num : nums) {
                set.add(num);
            }
            count++;
        }
        return count;
    }

    public static int[] maxElement(int[] nums) {
        int[] maxElement = {0, 0};

        for (int i = 0; i < nums.length; i++) {
            // 挑出最大的元素的下标
            if (maxElement[0] < nums[i]) {
                maxElement[0] = nums[i];
                maxElement[1] = i;
            }
        }
        return maxElement;
    }

    /**
     * 执行用时 : 14 ms , 在所有 Java 提交中击败了 29.26% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int law(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int po = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            count += (nums[i + 1] - nums[i]) * po;
            po--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(law(new int[]{1, 2, 4, 5}));
    }
}