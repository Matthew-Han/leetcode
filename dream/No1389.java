import java.util.Arrays;

/**
 * @ClassName CreateTargetArrayInTheGivenOrder
 * @Description #1389 按既定顺序创建目标数组
 * @Author MatthewHan
 * @Date 2020/7/13 10:39
 * @Version 1.0
 **/
public class No1389 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 90.35% 的用户
     * 内存消耗： 38 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @param index
     * @return
     */
    public static int[] createTargetArray(int[] nums, int[] index) {

        int len = index.length;
        int[] target = new int[len];

        for (int i = 0; i < len; i++) {
            int goalIndex = index[i];
            for (int j = len - 1; j > goalIndex; j--) {
                target[j] = target[j - 1];
            }
            target[goalIndex] = nums[i];
        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(new int[]{1, 1, 1}, new int[]{2, 2, 2})));
    }
}
