import java.util.Arrays;

/**
 * @ClassName RotateArray
 * @Description #189 旋转数组
 * @Author MatthewHan
 * @Date 2020/4/24 14:01
 * @Version 1.0
 **/
public class No189 {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40 MB , 在所有 Java 提交中击败了 7.14% 的用户
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {

        k = k % nums.length;
        int[] temp = new int[nums.length];
        int a = nums.length - k;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                temp[i] = nums[b];
                b++;
            } else {
                temp[i] = nums[a];
                a++;
            }
        }
        System.arraycopy(temp, 0, nums, 0, temp.length);
        System.out.println(Arrays.toString(nums));

    }


    /**
     * 执行用时 : 267 ms , 在所有 Java 提交中击败了 12.39% 的用户
     * 内存消耗 : 40.6 MB , 在所有 Java 提交中击败了 7.14% 的用户
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        while (k > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {

        rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);


    }
}
