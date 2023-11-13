package 春季编程大赛2022Solo;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/20 15:21 20
 * @since 1.0
 **/
public class Lcp50 {

    /**
     * 宝石补给
     *
     * @param gem
     * @param operations
     * @return
     */
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] xy : operations) {
            int c = gem[xy[0]];
            gem[xy[0]] -= c / 2;
            gem[xy[1]] += c / 2;
        }
        int max = 0xc0c0c0c0;
        int min = 0x3f3f3f3f;
        for (int j : gem) {
            max = Math.max(max, j);
            min = Math.min(min, j);
        }
        return max - min;
    }


}
