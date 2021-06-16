package 第244场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/7 15:34
 * @description
 * @since 1.0.0
 **/
public class No1886 {

    /**
     * #1886 判断矩阵经轮转后是否一致
     *
     * @param mat
     * @param target
     * @return
     */
    public boolean findRotation(int[][] mat, int[][] target) {
        if (method(mat, target)) {
            return true;
        }
        for (int k = 0; k < 3; k++) {
            int[][] tmp = new int[mat.length][mat.length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    tmp[i][j] = mat[j][tmp.length - 1 - i];
                }
            }
            mat = tmp;
            if (method(mat, target)) {
                return true;
            }
        }
        return false;
    }

    public boolean method(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
