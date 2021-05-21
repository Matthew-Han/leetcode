package 二维数组;

import javafx.util.Pair;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/12 23:41
 **/
public class No973 {


    /**
     * #973 最接近原点的 K 个点
     * <p>
     * 执行用时： 40 ms , 在所有 Java 提交中击败了 25.44% 的用户
     * 内存消耗： 46.8 MB , 在所有 Java 提交中击败了 78.94% 的用户
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {

        Arrays.sort(points, ((o1, o2) -> Double.compare((o1[0] * o1[0] + o1[1] * o1[1]), (o2[0] * o2[0] + o2[1] * o2[1]))));
        int[][] ans = new int[K][2];
        System.arraycopy(points, 0, ans, 0, ans.length);
        return ans;
    }

    public int[][] kClosest2(int[][] points, int K) {

        PriorityQueue<Pair<int[], Double>> pq = new PriorityQueue<>(K, (o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
        for (int[] curr : points) {
            Pair<int[], Double> pair = new Pair<>(curr, distance(curr));
            pq.offer(pair);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }

    public double distance(int[] xy) {
        return Math.sqrt(xy[0] * xy[0] + xy[1] * xy[1]);
    }
}
