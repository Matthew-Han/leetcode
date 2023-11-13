/**
 * @ClassName ValidMountainArray
 * @Description #941 有效的山脉数组
 * @Author MatthewHan
 * @Date 2020/6/26 16:39
 * @Version 1.0
 **/
public class No941 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param arr
     * @return
     */
    public static boolean validMountainArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                maxIndex = i;
                max = arr[i];
                // 峰顶更新，次数重置
                maxCount = 1;
            } else if (max == arr[i]) {
                // 统计峰顶次数
                maxCount++;
            }
        }
        /*
         * 1. 峰顶出现了2次及以上
         * 2. 峰顶出现在开头和结尾
         */
        if (maxCount > 1 || maxIndex == 0 || maxIndex == arr.length - 1) {
            return false;
        }

        int i = 0;
        int j = arr.length - 1;
        // 单峰顶的情况，是否左边单调递增但不能出现相同的元素
        while (i < maxIndex) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
            i++;
        }
        // 单峰顶的情况，是否右边单调递减但不能出现相同的元素
        while (maxIndex < j) {
            if (arr[maxIndex] <= arr[maxIndex + 1]) {
                return false;
            }
            maxIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{1, 7, 9, 5, 4, 1, 2}));
    }
}
