package 第54场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 15:15
 * @description
 * @since 1.0.0
 **/
public class No1893 {

    /**
     * #1893 检查是否区域内所有整数都被覆盖
     *
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean flag = true;
            for (int[] range : ranges) {
                if (i <= range[1] && i >= range[0]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return false;
            }
        }
        return true;
    }
}
