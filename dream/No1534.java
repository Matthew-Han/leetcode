/**
 * @ClassName CountGoodTriplets
 * @Description #1534 统计好三元组
 * @Author MatthewHan
 * @Date 2020/8/6 15:38
 * @Version 1.0
 **/
public class No1534 {

    /**
     * 执行用时： 19 ms , 在所有 Java 提交中击败了 49.97% 的用户
     * 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 98.08% 的用户
     *
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        countGoodTriplets(new int[]{1, 2, 3, 4, 5}, 1, 2, 3);
    }
}
