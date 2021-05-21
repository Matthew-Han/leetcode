package 二维数组;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/14 10:34
 **/
public class No1476 {

    private final int[][] rectangle;

    /**
     * #1476 子矩形查询
     * 执行用时： 30 ms , 在所有 Java 提交中击败了 82.45% 的用户
     * 内存消耗： 42.7 MB , 在所有 Java 提交中击败了 5.24% 的用户
     *
     * @param rectangle
     */
    public No1476(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = col1; i <= col2; i++) {
            for (int j = row1; j <= row2; j++) {
                rectangle[j][i] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public static void main(String[] args) {
        System.out.println("sadas: " + "abc".substring(0, 2));
        System.out.println("sadas: " + "abc".substring(0, 0));

    }
}
