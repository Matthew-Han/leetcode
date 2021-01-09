package 二分查找;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/10 01:27
 **/
public class SearchA2dMatrixII {


    /**
     * 右上角为起点的二叉搜索树
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 82.61% 的用户
     * 内存消耗： 43.7 MB , 在所有 Java 提交中击败了 91.28% 的用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixByBinarySearchTree(int[][] matrix, int target) {
        return dfs(matrix, target, 0, matrix[0].length - 1);
    }

    public boolean dfs(int[][] matrix, int target, int i, int j) {
        if (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                return dfs(matrix, target, i + 1, j);
            } else {
                return dfs(matrix, target, i, j - 1);
            }
        } else {
            return false;
        }
    }

    /**
     * 当做无限缩小范围的二分查找
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 18.35% 的用户
     * 内存消耗： 43.6 MB , 在所有 Java 提交中击败了 96.19% 的用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {

        int rowLimit = matrix[0].length - 1;
        int columnLimit = matrix.length - 1;
        int i = 0;
        int j = 0;
        while (true) {
            if (i > columnLimit || j > rowLimit) {
                return false;
            }
            int left = 0;
            int right = rowLimit;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    rowLimit = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            left = 0;
            right = columnLimit;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[mid][j] == target) {
                    return true;
                } else if (matrix[mid][j] < target) {
                    columnLimit = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            i++;
            j++;

        }

    }

    /**
     * #240 搜索二维矩阵 II
     * 执行用时： 17 ms , 在所有 Java 提交中击败了 9.64% 的用户
     * 内存消耗： 43.8 MB , 在所有 Java 提交中击败了 83.87% 的用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLimit = -1;
        int columnLimit = -1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[0][mid] == target) {
                return true;
            } else if (matrix[0][mid] < target) {
                rowLimit = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                columnLimit = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // System.out.println(rowLimit);
        // System.out.println(columnLimit);
        for (int i = 1; i <= columnLimit; i++) {
            for (int j = 1; j <= rowLimit; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
