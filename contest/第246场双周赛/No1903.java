package 第246场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/21 09:15
 * @since 1.0
 **/
public class No1903 {

    /**
     * #1903 字符串中的最大奇数
     *
     * @param num
     * @return
     */
    public String largestOddNumber(String num) {
        int index = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
