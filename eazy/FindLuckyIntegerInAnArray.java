/**
 * @ClassName FindLuckyIntegerInAnArray
 * @Description #1394 找出数组中的幸运数
 * @Author MatthewHan
 * @Date 2020/7/13 14:42
 * @Version 1.0
 **/
public class FindLuckyIntegerInAnArray {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @return
     */
    public static int findLucky(int[] arr) {
        int[] bucket = new int[500];
        for (int n : arr) {
            bucket[n]++;
        }
        // 倒序，因为要优先找最大的，注意index为0的情况
        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
