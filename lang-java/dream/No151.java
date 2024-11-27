import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReverseWordsInAstring
 * @Description #151 翻转字符串里的单词
 * @Author MatthewHan
 * @Date 2020/7/20 11:24
 * @Version 1.0
 **/
public class No151 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 90.21% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 5.26% 的用户
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if ("".equals(s) || null == s) {
            return "";
        }
        String[] strings = s.split(" ");

        List<String> list = new ArrayList<>(strings.length);
        for (String string : strings) {
            if (!"".equals(string)) {
                list.add(string);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        if (!sb.isEmpty()) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

}
