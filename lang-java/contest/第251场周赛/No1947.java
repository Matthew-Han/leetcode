package 第251场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/30 09:41
 * @since 1.0
 **/
public class No1947 {

    int max;

    /**
     * 最大兼容性评分和
     *
     * @param students
     * @param mentors
     * @return
     */
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        max = 0xc0c0c0c0;
        boolean[] vis = new boolean[students.length];
        dfs(students, mentors, 0, vis, 0);
        return max;
    }

    public void dfs(int[][] students, int[][] mentors, int index, boolean[] vis, int sum) {
        if (index == students.length) {
            max = Math.max(max, sum);
        }
        int m = students.length;
        int n = students[0].length;
        for (int i = index; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[j]) {
                    continue;
                }
                int tmp = 0;
                for (int k = 0; k < n; k++) {
                    tmp += students[i][k] == mentors[j][k] ? 1 : 0;
                }
                vis[j] = true;
                dfs(students, mentors, i + 1, vis, sum + tmp);
                vis[j] = false;
            }
        }
    }
}
