import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Matthew Han
 * @description
 * @date 2021/5/2 20:41
 * @since 1.0.0
 **/
public class BrickWall {

    /**
     * #554 砖墙
     *
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {
        List<List<Integer>> newType = new ArrayList<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (List<Integer> integers : wall) {
            List<Integer> tmp = new ArrayList<>();
            // size() - 1，因为最后一位不用取
            for (int j = 0; j < integers.size() - 1; j++) {
                int n = (tmp.size() - 1 >= 0 ? tmp.get(tmp.size() - 1) : 0) + integers.get(j);
                tmp.add(n);
                cnt.put(n, cnt.getOrDefault(n, 0) + 1);
            }
            newType.add(tmp);
        }
        // System.out.println(newType);
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                index = entry.getKey();
            }
        }

        int ans = 0;
        if (index == -1) {
            return wall.size();
        }
        for (List<Integer> integers : newType) {
            int j = 0;
            ans++;
            while (j < integers.size()) {
                if (integers.get(j) == index) {
                    ans--;
                    break;
                } else if (integers.get(j) > index) {
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}
