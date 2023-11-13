import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/20 11:11
 * @description
 * @since 1.0.0
 **/
public class No1738 {

    /**
     * #1738 找出第 K 大的异或坐标值
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        int[][] dp = new int[matrix.length][matrix[0].length];
        int x = 0;
        int y = 0;
        while (x < matrix.length && y < matrix[0].length) {
            for (int start = y; start < matrix[0].length; start++) {
                dp[x][start] = matrix[x][start];
                if (x > 0) {
                    dp[x][start] ^= dp[x - 1][start];
                }
                if (start > 0) {
                    dp[x][start] ^= dp[x][start - 1];
                }
                if (x > 0 && start > 0) {
                    dp[x][start] ^= dp[x - 1][start - 1];
                }
                // System.out.println("y: " + dp[x][start]);
                if (pq.size() < k) {
                    pq.offer(dp[x][start]);
                    continue;
                }
                if (pq.peek() < dp[x][start]) {
                    pq.poll();
                    pq.offer(dp[x][start]);
                }
            }
            x++;

            for (int start = x; start < matrix.length; start++) {
                dp[start][y] = matrix[start][y] ^ dp[start - 1][y];
                if (y > 0) {
                    dp[start][y] ^= dp[start][y - 1] ^ dp[start - 1][y - 1];
                }
                // System.out.println("x: " + dp[x][start]);
                if (pq.size() < k) {
                    pq.offer(dp[start][y]);
                    continue;
                }
                if (pq.peek() < dp[start][y]) {
                    pq.poll();
                    pq.offer(dp[start][y]);
                }
            }
            y++;

        }
        return pq.peek();
    }

    public static void main(String[] args) {

    }
}
