/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/4 12:36
 * @since 1.0
 **/
public class No390 {

    /**
     * 消除游戏
     *
     * @param t
     * @return
     */
    public int lastRemaining(int t) {
        int n = (t % 2 == 0) ? t : t - 1;
        int cnt = n / 2;
        int d = 2;
        int start = n;
        int end = 2;
        boolean flag = true;
        while (cnt > 1) {
            if (!flag) {
                if (cnt % 2 != 0) {
                    start -= d;
                    end += d;
                } else {
                    end += d;
                }

            } else {
                if (cnt % 2 != 0) {
                    start -= d;
                    end += d;
                } else {
                    start -= d;
                }
            }
            flag = !flag;
            d *= 2;
            cnt /= 2;
        }

        return t == 1 ? 1 : start;
    }
}
