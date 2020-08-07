package 双指针;

/**
 * @ClassName LcOf04
 * @Description 剑指 Offer #04 二维数组中的查找
 * @Author MatthewHan
 * @Date 2020/7/16 16:52
 * @Version 1.0
 **/
public class LcOf04 {

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

}
