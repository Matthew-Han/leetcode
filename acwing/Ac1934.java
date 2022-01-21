import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/18 12:21
 * @since 1.0
 **/
public class Ac1934 {


    /**
     * 贝茜放慢脚步
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        PriorityQueue<Integer> timeQ = new PriorityQueue<>();
        PriorityQueue<Double> distanceQ = new PriorityQueue<>();
        while (n-- > 0) {
            String[] t = sc.readLine().split(" ");
            int tmp = Integer.parseInt(t[1]);
            if ("D".equals(t[0])) {
                if (tmp < 1000) {
                    distanceQ.offer((double) tmp);
                }
            } else {
                timeQ.offer(tmp);
            }
        }
        double currV = 1;
        double currD = 0;
        double currT = 0;
        while (!timeQ.isEmpty() || !distanceQ.isEmpty()) {
            double deltaD = 1000 - currD;
            //
            if (!timeQ.isEmpty() && !distanceQ.isEmpty()) {
                int time = timeQ.poll();
                double distance = distanceQ.poll();
                double d1 = (time - currT) / currV;
                double d2 = distance - currD;
                if (d1 <= d2) {
                    if (d1 < deltaD) {
                        deltaD = d1;
                    } else {
                        // todo
                        System.out.println(Math.round(currT + deltaD * currV));
                        return;
                    }
                    distanceQ.offer(distance);
                } else {
                    deltaD = distance - currD;
                    timeQ.offer(time);
                }
            } else if (timeQ.isEmpty()) {
                double distance = distanceQ.poll();
                deltaD = distance - currD;
            } else {
                int time = timeQ.poll();
                double d = (time - currT) / currV;
                if (d < deltaD) {
                    deltaD = d;
                } else {
                    // todo
                    System.out.println(Math.round(currT + deltaD * currV));
                    return;
                }
            }
            currD += deltaD;
            currT += deltaD * currV;
            currV++;

        }
        System.out.println(currD < 1000 ? Math.round(currT + (1000 - currD) * currV) : Math.round(currT));

    }

}
