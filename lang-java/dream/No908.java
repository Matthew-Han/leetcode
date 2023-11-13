/**
 * @ClassName SmallestRangeI
 * @Description #908 最小差值 I
 * @Author MatthewHan
 * @Date 2020/6/23 10:39
 * @Version 1.0
 **/
public class No908 {

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 72.25% 的用户
     * 内存消耗： 40.3 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param arr
     * @param k
     * @return
     */
    public static int smallestRangeI(int[] arr, int k) {
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int i : arr) {
            maxNum = Math.max(maxNum, i);
            minNum = Math.min(minNum, i);
        }

        System.out.println("maxNum = " + maxNum);
        System.out.println("minNum = " + minNum);

        return maxNum - minNum > k * 2 ? maxNum - minNum - k * 2 : 0;
    }

    public static void main(String[] args) {
        System.out.println(smallestRangeI(new int[]{1}, 3));
    }
}
