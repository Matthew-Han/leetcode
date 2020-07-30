import java.util.Arrays;

/**
 * @ClassName RectangleOverlap
 * @Description #836 矩形重叠
 * @Author MatthewHan
 * @Date 2020/6/19 14:40
 * @Version 1.0
 **/
public class RectangleOverlap {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        /*
         * 矩形 a 的最左边大于矩形 b 的最右边
         * 矩形 b 的最左边大于矩形 a 的最右边
         */
        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2]) {
            return false;
        }
        return rec1[1] < rec2[3] && rec1[3] > rec2[1];

    }

    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
    }
}
