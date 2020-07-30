import java.util.Arrays;

/**
 * @ClassName HeightChecker
 * @Description #1051 高度检查器
 * @Author MatthewHan
 * @Date 2020/7/5 03:15
 * @Version 1.0
 **/
public class HeightChecker {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 82.41% 的用户
     * 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] prev = heights.clone();
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != prev[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
