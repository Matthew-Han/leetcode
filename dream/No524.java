import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/14 10:21
 * @since 1.0
 **/
public class No524 {

    /**
     * 通过删除字母匹配到字典里最长单词
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        dictionary.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) != o2.charAt(i)) {
                        return Character.compare(o2.charAt(i), o1.charAt(i));
                    }
                }
            }
            return Integer.compare(o1.length(), o2.length());
        });
        for (String d : dictionary) {
            if (intersection(s, d)) {
                ans = d;
            }
        }
        return ans;
    }

    public boolean intersection(String src, String target) {
        int index = 0;
        for (int i = 0; i < target.length(); i++) {
            boolean flag = true;
            for (int j = index; j < src.length(); j++) {
                if (src.charAt(j) == target.charAt(i)) {
                    index = j + 1;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return false;
            }
        }
        return true;
    }
}
