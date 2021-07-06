package 第248场周赛;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/4 10:29
 * @since 1.0
 **/
public class No1921 {


    /**
     * 消灭怪物的最大数量
     *
     * @param dist
     * @param speed
     * @return
     */
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] tmp = new int[dist.length];
        int ans = 0;
        for (int i = 0; i < dist.length; i++) {
            tmp[i] = dist[i] / speed[i];
            tmp[i] += dist[i] % speed[i] > 0 ? 1 : 0;
        }
        Arrays.sort(tmp);
        for (int i = 0; i < dist.length; i++) {
            if (i >= tmp[i]) {
                return ans;
            } else {
                ans++;
            }
        }
        return ans;
    }

}
