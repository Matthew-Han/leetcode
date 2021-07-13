import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/13 17:57
 * @since 1.0
 **/
public class No218 {

    /**
     * 天际线问题
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> fuck = new ArrayList<>();
        for (int[] curr : buildings) {
            int y = curr[2];
            for (int k = 0; k < 2; k++) {
                boolean flag = true;
                for (int[] building : buildings) {
                    if (building[2] > y && building[0] <= curr[k] && building[1] >= curr[k]) {
                        flag = false;
                        break;

                    }
                }
                if (flag) {
                    ans.add(new ArrayList<>(Arrays.asList(curr[k], y, k)));
                }
            }
        }
        System.out.println(ans);
        for (List<Integer> sub : ans) {
            if (sub.get(2) == 0) {
                fuck.add(new ArrayList<>(Arrays.asList(sub.get(0), sub.get(1))));

            } else {
                int x = sub.get(0);
                int y = sub.get(1);
                int hh = 0;
                for (int[] building : buildings) {
                    if (building[2] < y && building[0] < x && building[1] > x) {
                        hh = Math.max(hh, building[2]);
                    }
                }

                fuck.add(new ArrayList<>(Arrays.asList(sub.get(0), hh)));
            }

        }
        return fuck;
    }
}
