import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LcOf58
 * @Description 剑指 Offer #58 - I 翻转单词顺序
 * @Author MatthewHan
 * @Date 2020/7/20 12:33
 * @Version 1.0
 **/
public class L58I {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 88.17% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
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
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }
}
