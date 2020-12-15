package 贪心;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/15 15:17
 **/
public class MonotoneIncreasingDigits {


    /**
     * #738 单调递增的数字
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 32.32% 的用户
     * 内存消耗： 35.4 MB , 在所有 Java 提交中击败了 55.78% 的用户
     *
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        int index = -1;
        boolean flag = false;
        int curr = str.charAt(0) - '0';
        for (int i = 1; i < str.length(); i++) {
            int next = str.charAt(i) - '0';
            if (curr > next) {
                if (index == -1) {
                    index = i - 1;
                }
                flag = true;
                break;
            } else if (index == -1 && curr == next) {
                index = i - 1;
            } else if (curr < next) {
                index = -1;
            }
            curr = next;
        }
        StringBuilder ans = new StringBuilder();
        if (flag) {
            for (int i = 0; i < index; i++) {
                ans.append(str.charAt(i));
            }
            int tmp = (str.charAt(index) - '0') - 1;
            ans.append(tmp);
            for (int i = 0; i < str.length() - index - 1; i++) {
                ans.append(9);
            }
            return Integer.parseInt(ans.toString());

        } else {
            return N;
        }
    }
}
