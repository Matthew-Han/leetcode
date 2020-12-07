package 贪心;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/7 11:46
 **/
public class ScoreAfterFlippingMatrix {


    /**
     * #861 翻转矩阵后的得分
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 29.27% 的用户
     * 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 68.64% 的用户
     *
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int ans = 0;
        // step1. 翻转第一位
        for (int[] arr : A) {
            if (arr[0] == 0) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = arr[i] == 0 ? 1 : 0;
                }
            }
        }
        int x = A.length;
        int y = A[0].length;
        int flag = 0;
        for (int i = 0; i < y; i++) {
            int count0 = 0;
            for (int[] ints : A) {
                count0 += ints[i] == 0 ? 1 : 0;
            }
            // 如果当前位 0 的数量超过一半（不含）就需要翻转当前首位为 0 的数组
            if (count0 > x / 2) {
                for (int j = 0; j < x; j++) {
                    A[j][i] = A[j][i] == 0 ? 1 : 0;
                }
            }
        }
        // System.out.println(Arrays.deepToString(A));
        StringBuilder sb = new StringBuilder();
        for (int[] ints : A) {
            for (int j = 0; j < y; j++) {
                sb.append(ints[j]);
            }
            int curr = Integer.parseInt(sb.toString(), 2);
            ans += curr;
            sb.setLength(0);
        }
        return ans;
    }
}
