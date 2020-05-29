/**
 * @ClassName CountBinarySubstrings
 * @Description #696 计数二进制子串
 * @Author MatthewHan
 * @Date 2020/5/29 12:56
 * @Version 1.0
 **/
public class CountBinarySubstrings {

    /**
     * 超出时间限制
     *
     * @param s
     * @return
     */
    public static int countBinarySubstrings(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            int c = 1;
            char point = s.charAt(i);
            boolean go = true;
            for (; j < len; j++) {
                if (go && point == s.charAt(j)) {
                    c++;
                } else {
                    go = false;
                    if (point == s.charAt(j)) {
                        break;
                    }
                    if (j >= (i - 1 + c * 2)) {
                        count++;
                        break;
                    }
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00111001010110001011"));
    }
}
