import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName UniqueMorseCodeWords
 * @Description #804 唯一摩尔斯密码词
 * @Author MatthewHan
 * @Date 2020/6/17 14:52
 * @Version 1.0
 **/
public class UniqueMorseCodeWords {

    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 60.89% 的用户
     * 内存消耗 : 37.3 MB , 在所有 Java 提交中击败了 12.50% 的用户
     *
     * @param words
     * @return
     */
    public static int uniqueMorseRepresentations(String[] words) {
        String[] aBcd = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new HashSet<>(words.length * 4 / 3 + 1);
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(aBcd[word.charAt(i) - 97]);
            }
            set.add(sb.toString());
        }
        return set.size();

    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
