import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/9 15:46
 * @since 1.0
 **/
public class No68 {

    /**
     * 文本左右对齐
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        int len = -1;
        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() + 1 <= maxWidth) {
                len += words[i].length() + 1;
                sub.add(words[i]);
            } else {
                fuck(ans, sub, maxWidth);
                sub = new ArrayList<>();
                len = -1;
                i--;
                continue;
            }
            if (i == words.length - 1) {
                fuck(ans, sub, maxWidth);
            }
        }
        ans.set(ans.size() - 1, fuck(ans.get(ans.size() - 1), maxWidth));
        return ans;
    }

    public void fuck(List<String> ans, List<String> sub, int maxWidth) {
        if (sub.size() == 1) {
            ans.add(sub.get(0) + build(maxWidth - sub.get(0).length()));
            return;
        }
        int len = 0;
        for (String s : sub) {
            len += s.length();
        }
        int d = maxWidth - len;
        int b = d / (sub.size() - 1);
        int c = d % (sub.size() - 1);
        String k = build(b);
        StringBuilder tmp = new StringBuilder(sub.get(0));
        for (int i = 1; i < sub.size(); i++) {
            if (c-- > 0) {
                tmp.append(" ");
            }
            tmp.append(k);
            tmp.append(sub.get(i));
        }
        ans.add(tmp.toString());

    }

    public String fuck(String str, int maxWidth) {
        int len = -1;
        while (len != str.length()) {
            len = str.length();
            str = str.replace("  ", " ");
        }
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (!" ".equals(s)) {
                sb.append(s);
                if (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }
        }
        sb.append(build(maxWidth - sb.length()));
        return sb.toString();
    }

    public String build(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
