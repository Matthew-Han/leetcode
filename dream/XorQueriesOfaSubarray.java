/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/12 15:27
 * @description
 * @since 1.0.0
 **/
public class XorQueriesOfaSubarray {

    /**
     * #1310 子数组异或查询
     *
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] tmp = new int[arr.length];
        tmp[0] = arr[0];
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] = arr[i] ^ tmp[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = (queries[i][0] - 1 < 0 ? 0 : tmp[queries[i][0] - 1]) ^ tmp[queries[i][1]];

        }
        return ans;
    }
}
