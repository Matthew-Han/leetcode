package 第251场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/30 09:40
 * @since 1.0
 **/
public class No1946 {

    /**
     * 子字符串突变后可能得到的最大整数
     *
     * @param num
     * @param change
     * @return
     */
    public String maximumNumber(String num, int[] change) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (flag == 0) {
                if (n >= change[n]) {
                    sb.append(n);
                } else {
                    sb.append(change[n]);
                    flag = 1;
                }
            } else if (flag == 1) {
                if (n > change[n]) {
                    sb.append(n);
                    flag = 2;
                } else {
                    sb.append(change[n]);
                }
            } else {
                sb.append(n);
            }
        }
        return sb.toString();
    }
}
