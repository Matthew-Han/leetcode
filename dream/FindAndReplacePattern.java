import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/18 17:49
 **/
public class FindAndReplacePattern {

    /**
     * #890 查找和替换模式
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 79.76% 的用户
     * 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 75.60% 的用户
     *
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        String newPattern = convert(pattern);
        for (String word : words) {
            String tmp = convert(word);
            if (newPattern.contains(tmp)) {
                res.add(word);
            }
        }
        return res;
    }

    public String convert(String word) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>(word.length());
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            int ii = list.indexOf(curr);
            if (ii == -1) {
                list.add(curr);
                sb.append(index);
                index++;
            } else {
                sb.append(ii);
            }
        }
        return sb.toString();
    }
}
