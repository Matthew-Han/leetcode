import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @since 2025/9/1 03:49:15
 **/
public class No1792 {


    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            double o1diff = (double) (o1[0] + 1) / (o1[1] + 1) - (double) (o1[0]) / o1[1];
            double o2diff = (double) (o2[0] + 1) / (o2[1] + 1) - (double) (o2[0]) / o2[1];
            return Double.compare(o2diff, o1diff);
        });
        for (int[] pair : classes) {
            pq.offer(pair);
        }
        while (extraStudents-- > 0) {
            int[] min = pq.poll();
            pq.offer(new int[]{min[0] + 1, min[1] + 1});
        }
        double ans = 0d;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            System.out.println("tmp = " + Arrays.toString(tmp));
            ans += ((double) tmp[0] / tmp[1]);
        }
        return ans / classes.length;

    }

}
