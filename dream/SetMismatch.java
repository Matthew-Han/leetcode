import java.util.Arrays;

/**
 * @ClassName SetMismatch
 * @Description #645 错误的集合
 * @Author MatthewHan
 * @Date 2020/5/23 16:43
 * @Version 1.0
 **/
public class SetMismatch {

    /**
     * 原数组扩容。最左端加一个0，最右端加一个原数组长度+1的数字。
     * 1. 判断相邻相减==0，结果的第1位就是当前位置的数字。
     * 2. 判断相邻相减==2，结果的第2位就是当前位置的数字+1。
     * <p>
     * 执行用时 : 13 ms , 在所有 Java 提交中击败了 30.91% 的用户
     * 内存消耗 : 41.8 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Arrays.sort(nums);
        int[] temp = new int[nums.length + 2];
        temp[0] = 0;
        temp[temp.length - 1] = nums.length + 1;
        System.arraycopy(nums, 0, temp, 1, nums.length);

        for (int i = 0; i < temp.length; i++) {
            if (i + 1 < temp.length && temp[i + 1] - temp[i] == 0) {
                result[0] = temp[i];
            }
            if (i + 1 < temp.length && temp[i + 1] - temp[i] == 2) {
                System.out.println(1);
                result[1] = temp[i] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findErrorNums(new int[]{3, 2, 3, 4, 6, 5})));
    }
}
