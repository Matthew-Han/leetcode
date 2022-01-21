import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/18 09:51
 * @since 1.0
 **/
public class No539 {

    /**
     * 最小时间差
     *
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        int ans = 24 * 60;
        List<Integer> fuck = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] t = timePoint.split(":");
            int total = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            fuck.add(total);
            fuck.add(total + 24 * 60);
        }
        fuck.sort(Integer::compare);
        for (int i = 1; i < fuck.size(); i++) {
            ans = Math.min(ans, fuck.get(i) - fuck.get(i - 1));
        }
        return ans;
    }
}
