/**
 * @ClassName SumOfEvenNumbersAfterQueries
 * @Description #985 查询后的偶数和
 * @Author MatthewHan
 * @Date 2020/6/30 09:52
 * @Version 1.0
 **/
public class SumOfEvenNumbersAfterQueries {

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 99.16% 的用户
     * 内存消耗： 47.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @param queries
     * @return
     */
    public static int[] sumEvenAfterQueries(int[] arr, int[][] queries) {
        int[] result = arr.clone();
        // 设置一个缓存：上一次的偶数和
        int evenSum = 0;
        for (int value : arr) {
            if ((value & 1) == 0) {
                evenSum += value;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int val = queries[i][0];
            /*
             * 判断当前未操作前的元素是否是偶数
             * 是：缓存偶数和先删除该元素
             * 否：跳过
             */
            if ((arr[index] & 1) == 0) {
                evenSum -= arr[index];
            }
            arr[index] += val;

            // 操作后的元素如果是偶数加入到缓存里
            evenSum += (arr[index] & 1) == 0 ? arr[index] : 0;
            result[i] = evenSum;
        }
        return result;
    }


}
