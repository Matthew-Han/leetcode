import java.util.Arrays;

/**
 * @ClassName ReshapeTheMatrix
 * @Description #566 重塑矩阵
 * @Author MatthewHan
 * @Date 2020/5/20 17:10
 * @Version 1.0
 **/
public class ReshapeTheMatrix {

    /**
     * 二维数组
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 83.60% 的用户
     * 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int area = nums[0].length * nums.length;
        if (area != r * c) {
            return nums;
        }
        int[] temp = new int[area];

        int y = 0;
        int i = 0;
        for (; y < nums.length; y++) {
            int x = 0;
            for (; x < nums[y].length; x++) {
                temp[i] += nums[y][x];
                i++;
            }
        }
        // 赋值
        int[][] result = new int[r][c];
        y = 0;
        i = 0;
        for (; y < r; y++) {
            int x = 0;
            for (; x < c; x++) {
                result[y][x] = temp[i];
                i++;
            }
        }
        System.out.println(Arrays.toString(temp));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1)));
    }
}
