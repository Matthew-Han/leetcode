/**
 * @ClassName DecryptStringFromAlphabetToIntegerMapping
 * @Description #1309 解码字母到整数映射
 * @Author MatthewHan
 * @Date 2020/7/10 10:45
 * @Version 1.0
 **/
public class DecryptStringFromAlphabetToIntegerMapping {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 82.33% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 5.09% 的用户
     *
     * @param s
     * @return
     */
    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char temp = s.charAt(i);
            if (temp != '#') {
                sb.append((char) (temp + 48));
            } else {
                int number = Integer.parseInt(s.substring(i - 2, i)) - 10;
                sb.append((char) (number + 'j'));
                i -= 2;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

    }
}
