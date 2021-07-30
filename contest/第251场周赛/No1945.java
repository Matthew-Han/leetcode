package 第251场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/30 09:39
 * @since 1.0
 **/
public class No1945 {

    /**
     * 字符串转化后的各位数字之和
     *
     * @param s
     * @param k
     * @return
     */
    public int getLucky(String s, int k) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char value : arr) {
            sb.append(value - 'a' + 1);
        }
        s = sb.toString();
        for (int i = 0; i < k; i++) {
            arr = s.toCharArray();
            int tmp = 0;
            for (char c : arr) {
                tmp += c - '0';
            }
            s = "" + tmp;
        }
        return Integer.parseInt(s);
    }
}
