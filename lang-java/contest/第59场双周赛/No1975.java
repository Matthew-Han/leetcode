package 第59场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/23 10:42
 * @since 1.0
 **/
public class No1975 {

    /**
     * 最大方阵和
     *
     * @param matrix
     * @return
     */
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = 0x3f3f3f3f;
        int cnt = 0;
        for (int[] ints : matrix) {
            for (int i : ints) {
                cnt += i < 0 ? 1 : 0;
                sum += Math.abs(i);
                min = Math.min(Math.abs(i), min);
            }
        }
        if (cnt % 2 == 0) {
            return sum;
        } else {
            return sum - (2L * min);
        }
    }
}
