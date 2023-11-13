import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/9/29 14:25 29
 * @since 1.0
 **/
public class No857 {

    /**
     * 雇佣 K 名工人的最低成本
     *
     * @param quality
     * @param wage
     * @param k
     * @return
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ans = 0x3f3f3f3f;
        int len = quality.length;
        PriorityQueue<Double> q = new PriorityQueue<>((o1, o2) -> Double.compare(o2, o1));
        List<Double[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            double x = (double) wage[i] / (double) quality[i];
            list.add(new Double[]{(double) quality[i], (double) wage[i], x});
        }
        double x = 0d;
        list.sort(Comparator.comparingDouble(o -> o[2]));
        int t = 0;
        for (int i = 0; i < len; i++) {
            if (q.size() < k) {
                t += list.get(i)[0];
                q.offer(list.get(i)[0]);
            } else {
                ans = Math.min(ans, t * x);
                if (q.peek() > list.get(i)[0]) {
                    Double old = q.poll();
                    q.offer(list.get(i)[0]);
                    t -= old;
                    t += list.get(i)[0];
                    x = list.get(i)[2];
                }
                ans = Math.min(ans, t * x);
            }
            x = list.get(i)[2];
        }
        ans = Math.min(ans, t * x);
        return ans;
    }



}
