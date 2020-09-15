package dp;

import java.util.Arrays;

/**
 * @ClassName UniquePaths
 * @Description #62 不同路径
 * @Author MatthewHan
 * @Date 2020/9/12 23:54
 * @Version 1.0
 **/
public class UniquePaths {
    int count;

    public int uniquePaths(int m, int n) {
        dfs(m, n, 0, 0, 0);
        return count;
    }

    public void dfs(int m, int n, int i, int j, int size) {
        if (i < m && j < n) {
            if (size == m + n - 2) {
                count++;
                return;
            }
            dfs(m, n, i + 1, j, size + 1);
            dfs(m, n, i, j + 1, size + 1);
        }
    }
}
