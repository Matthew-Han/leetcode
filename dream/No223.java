/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/30 15:40
 * @since 1.0
 **/
public class No223 {

    /**
     * 矩形面积
     *
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1) + Math.abs(bx2 - bx1) * Math.abs(by2 - by1);
        if (ax2 <= bx1 || ax1 >= bx2) {
            return area;
        }
        if (by2 <= ay1 || by1 >= ay2) {
            return area;
        }
        int a = Math.max(ax1, bx1);
        int b = Math.min(ax2, bx2);

        int c = Math.max(ay1, by1);
        int d = Math.min(ay2, by2);

        int cross = Math.abs(b - a) * Math.abs(d - c);
        return area - cross;
    }
}
