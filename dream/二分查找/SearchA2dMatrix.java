package 二分查找;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/30 12:26
 **/
public class SearchA2dMatrix {

    /**
     * #74 搜索二维矩阵
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38 MB , 在所有 Java 提交中击败了 44.12% 的用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int row = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            row = mid;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {

                left = mid + 1;
            } else {

                right = mid - 1;
            }
        }
        // System.out.println(row);
        // 选择一行
        if (matrix[row][0] > target && row > 0) {
            row--;
        }

        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
