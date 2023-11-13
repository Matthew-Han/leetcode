package 第63场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/18 14:48
 * @since 1.0
 **/
public class No2038 {

    /**
     * 如果相邻两个颜色均相同则删除当前颜色
     *
     * @param colors
     * @return
     */
    public boolean winnerOfGame(String colors) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < colors.length() - 2; i++) {
            if (colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A' && colors.charAt(i + 2) == 'A') {
                cnt1++;
            }
        }
        for (int i = 0; i < colors.length() - 2; i++) {
            if (colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B' && colors.charAt(i + 2) == 'B') {
                cnt2++;
            }
        }
        return cnt1 > cnt2;
    }
}
