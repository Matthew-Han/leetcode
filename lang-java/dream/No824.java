import java.util.Arrays;

/**
 * @ClassName GoatLatin
 * @Description #824 山羊拉丁文
 * @Author MatthewHan
 * @Date 2020/6/19 09:50
 * @Version 1.0
 **/
public class No824 {

    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 77.40% 的用户
     * 内存消耗 : 38.3 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param s
     * @return
     */
    public static String toGoatLatin(String s) {
        String[] temp = s.split(" ");
        String vowel = "aeiouAEIOU";
        for (int i = 0; i < temp.length; i++) {
            String word = temp[i];

            StringBuilder stringBuilder = new StringBuilder();
            if (vowel.contains(String.valueOf(word.charAt(0)))) {
                stringBuilder.append(word).append("ma").append(fuck(i));
            } else {
                char[] fucker = word.toCharArray();
                for (int j = 1; j < fucker.length; j++) {
                    stringBuilder.append(fucker[j]);
                }
                stringBuilder.append(fucker[0]).append("ma").append(fuck(i));
            }
            temp[i] = stringBuilder.toString();

        }
        System.out.println("temp = " + Arrays.toString(temp));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : temp) {
            stringBuilder.append(s1).append(" ");
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String fuck(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            stringBuilder.append("a");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        toGoatLatin("The quick brown fox jumped over the lazy dog");
    }
}
