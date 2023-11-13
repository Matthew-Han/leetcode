/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/14 09:38
 **/
public class No1375 {

    /**
     * #1375 灯泡开关 III
     *
     * @param light
     * @return
     */
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int j : light) {
            max = Math.max(max, j);
            if (cnt == max - 1) {
                ans++;
            }
            cnt++;


        }
        return ans;
    }
}
