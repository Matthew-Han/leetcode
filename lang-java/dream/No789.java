/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/23 10:46
 * @since 1.0
 **/
public class No789 {

    /**
     * 逃脱阻碍者
     *
     * @param ghosts
     * @param target
     * @return
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int minDistance = 0x3f3f3f3f;
        for (int[] ghost : ghosts) {
            int dist = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            minDistance = Math.min(minDistance, dist);
        }
        return (Math.abs(target[0]) + Math.abs(target[1])) < minDistance;
    }
}
