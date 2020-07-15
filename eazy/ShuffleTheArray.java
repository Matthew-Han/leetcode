import java.util.Arrays;

/**
 * @ClassName ShuffleTheArray
 * @Description #1470 重新排列数组
 * @Author MatthewHan
 * @Date 2020/7/15 10:41
 * @Version 1.0
 **/
public class ShuffleTheArray {

    /**
     * 原地修改
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 7.19% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @param n
     * @return
     */
    public static int[] shufflePro(int[] nums, int n) {
        int index = n;
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[index];
            for (int j = index; j >= i + 1; j--) {
                nums[j] = nums[j - 1];
            }
            index++;
            nums[i + 1] = temp;
        }
        return nums;
    }

    /**
     * 空间换时间
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @param n
     * @return
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i += 2) {
            result[i] = nums[i / 2];
            result[i + 1] = nums[n];
            n++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shufflePro(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
        System.out.println(Arrays.toString(new int[]{1, 4, 2, 3, 3, 2, 4, 1}));
    }
}
