import java.util.Arrays;

/**
 * @ClassName ArrayPartitionI
 * @Description #561 数组拆分 I
 * @Author MatthewHan
 * @Date 2020/5/20 16:54
 * @Version 1.0
 **/
public class ArrayPartitionI {

    /**
     * 数学问题
     * 执行用时 : 13 ms , 在所有 Java 提交中击败了 96.02% 的用户
     * 内存消耗 : 41.8 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{2, 4, 6, 3, 4564, 123, 79, 24, 1231}));
    }
}
