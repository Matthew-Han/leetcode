package 第250场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/19 09:19
 * @since 1.0
 **/
public class No1936 {

    /**
     * 新增的最少台阶数
     *
     * @param rungs
     * @param dist
     * @return
     */
    public int addRungs(int[] rungs, int dist) {
        int ans = 0;
        int prev = 0;
        for (int rung : rungs) {
            if (rung - prev > dist) {
                ans += (rung - prev) % dist == 0 ? ((rung - prev) / dist - 1) : ((rung - prev) / dist);
            }
            prev = rung;
        }
        return ans;
    }
}
