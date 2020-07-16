package 剑指Offer;

/**
 * @ClassName LcOf04
 * @Description 剑指 Offer #04 二维数组中的查找
 * @Author MatthewHan
 * @Date 2020/7/16 16:52
 * @Version 1.0
 **/
public class LcOf04 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int max = Math.max(m, n);
        int start = 0;
        int start2 = 0;
        while (max > 0) {
            int mLeft = start;
            int mRight = matrix[0].length - 1;

            int nLeft = start2;
            int nRight = matrix.length - 1;

            System.out.println("mLeft = " + mLeft);
            System.out.println("mRight = " + mRight);
            if (start < m) {
                while (mLeft <= mRight) {

                    int mid = mLeft + (mRight - mLeft) / 2;
                    System.out.println("start = " + start);
                    System.out.println("mid = " + mid);
                    if (matrix[start2][mid] == target) {
                        return true;
                    } else if (matrix[start2][mid] < target) {
                        mLeft = mid + 1;
                    } else {
                        mRight = mid - 1;
                    }
                }

                start++;


            }

            System.out.println("ganla");
            if (start2 < n) {
                while (nLeft <= nRight) {
                    int mid = nLeft + (nRight - nLeft) / 2;
                    if (matrix[mid][start] == target) {
                        return true;
                    } else if (matrix[mid][start] < target) {
                        nLeft = mid + 1;
                    } else {
                        nRight = mid - 1;
                    }
                }
                start2++;
            }
            max--;
        }

        return false;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 45.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArrayViolence(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int n : ints) {
                if (n == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findNumberIn2DArray(new int[][]{}, 8));
    }
}
