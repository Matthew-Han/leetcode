package dfs;

import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;
import java.util.*;

/**
 * @ClassName dfs.SortTheMatrixDiagonally
 * @Description #1329 将矩阵按对角线排序
 * @Author MatthewHan
 * @Date 2020/9/10 17:59
 * @Version 1.0
 **/
public class SortTheMatrixDiagonally {

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 88.52% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 99.28% 的用户
     *
     * @param mat
     * @return
     */
    public static int[][] diagonalSort(int[][] mat) {
        int xLen = mat.length;
        int yLen = mat[0].length;


        for (int i = 0; i < mat.length; i++) {
            int[] tmp = new int[Math.min(xLen - i, yLen)];
            dfs(mat, i, 0, 0, tmp);
            Arrays.sort(tmp);
            dfs2(mat, i, 0, 0, tmp);

        }

        for (int i = 1; i < mat[0].length; i++) {
            int[] tmp = new int[Math.min(xLen, yLen - i)];
            dfs(mat, 0, i, 0, tmp);
            Arrays.sort(tmp);
            dfs2(mat, 0, i, 0, tmp);
        }

        return mat;
    }

    public static void dfs(int[][] mat, int x, int y, int index, int[] tmp) {
        if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
            tmp[index] = mat[x][y];
            dfs(mat, x + 1, y + 1, index + 1, tmp);
        }
    }

    public static void dfs2(int[][] mat, int x, int y, int index, int[] tmp) {
        if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
            mat[x][y] = tmp[index];
            dfs2(mat, x + 1, y + 1, index + 1, tmp);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(diagonalSort(new int[][]{{37, 98, 82, 45, 42}})));
    }

}
