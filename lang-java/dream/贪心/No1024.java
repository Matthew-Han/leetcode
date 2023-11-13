package 贪心;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @date 2020/10/26 02:40
 **/
public class No1024 {

    int count = 1;

    /**
     * #1024 视频拼接
     *
     * @param clips
     * @param t
     * @return
     */
    public int videoStitching(int[][] clips, int t) {
        int max = 0;
        // 裁剪的片段没有比T时间大的片段
        int error = 0;
        for (int[] ints : clips) {
            error = Math.max(ints[1], error);
            if (ints[0] == 0 && ints[1] >= max) {
                max = ints[1];
            }
        }
        if (error < t) {
            return -1;
        }
        if (max >= t) {
            return count;
        }

        dfs(clips, t, max);
        return count;

    }

    public void dfs(int[][] clips, int t, int start) {
        if (start >= t) {
            return;
        }
        int max = start;
        for (int[] ints : clips) {
            if (ints[0] <= start && ints[1] >= max) {
                max = ints[1];
            }
        }
        // 一直没变，说明找不到符合条件的
        if (max == start) {
            count = -1;
            return;
        }
        count++;
        dfs(clips, t, max);
    }
}
