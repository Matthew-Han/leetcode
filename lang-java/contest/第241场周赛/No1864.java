package 第241场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/18 10:55
 * @description
 * @since 1.0.0
 **/
public class No1864 {

    /**
     * #1864 构成交替字符串需要的最小交换次数
     *
     * @param s
     * @return
     */
    public int minSwaps(String s) {
        char[] curr = s.toCharArray();
        int count1 = 0;
        for (char c : curr) {
            count1 += c == '1' ? 1 : 0;
        }
        boolean flag = (curr.length & 1) == 1;
        if (flag) {
            if (Math.abs(curr.length - 2 * count1) != 1) {
                return -1;
            }
        } else {
            if (count1 * 2 != curr.length) {
                return -1;
            }
        }
        int ans = 0x3f3f3f3f;
        int oddCnt0 = 0;
        int oddCnt1 = 0;
        for (int i = 0; i < curr.length; i += 2) {
            oddCnt0 += curr[i] == '0' ? 1 : 0;
            oddCnt1 += curr[i] == '1' ? 1 : 0;
        }
        if (flag) {
            // choose one on the edge
            if (count1 > curr.length / 2) {
                ans = Math.min(ans, curr.length / 2 + 1 - oddCnt1);
            } else {
                ans = Math.min(ans, curr.length / 2 + 1 - oddCnt0);
            }
        } else {
            if (oddCnt0 >= oddCnt1) {
                ans = Math.min(ans, s.length() / 2 - oddCnt0);
            } else {
                ans = Math.min(ans, s.length() / 2 - oddCnt1);
            }
        }
        return Math.max(ans, 0);

    }
}
