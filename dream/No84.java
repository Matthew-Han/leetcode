/**
 * @ClassName LargestRectangleInHistogram
 * @Description #84 柱状图中最大的矩形
 * @Author MatthewHan
 * @Date 2020/7/23 09:40
 * @Version 1.0
 **/
public class No84 {

    /**
     * 执行用时： 876 ms , 在所有 Java 提交中击败了 24.72% 的用户
     * 内存消耗： 40.7 MB , 在所有 Java 提交中击败了 73.91% 的用户
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int leftArea = 0;
            int rightArea = 0;
            int currHeight = heights[i];
            // 从指针向两端遍历
            for (int j = i; j >= 0; j--) {
                if (heights[j] != 0 && heights[j] >= currHeight) {
                    leftArea += currHeight;
                } else {
                    // 在这个过程中出现了比当前高度小的，就直接break
                    break;
                }
            }
            for (int k = i + 1; k < heights.length; k++) {
                if (heights[k] != 0 && heights[k] >= currHeight) {
                    rightArea += currHeight;
                } else {
                    // 在这个过程中出现了比当前高度小的，就直接break
                    break;
                }
            }
            maxHeight = Math.max(maxHeight, (leftArea + rightArea));

        }
        return maxHeight;
    }

}
