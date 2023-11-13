import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/25 12:56
 **/
public class No1592 {

    /**
     * #1592 重新排列单词间的空格
     *
     * @param text
     * @return
     */
    public String reorderSpaces(String text) {
        StringBuilder res = new StringBuilder();
        List<String> list = fuck(text);
        int c = count(text);
        int len = list.size();
        if (len == 1) {
            res.append(list.get(0));
            for (int i = 0; i < c; i++) {
                res.append(" ");
            }
            return res.toString();
        }
        int d1 = c / (len - 1);
        int d2 = c % (len - 1);
        for (String s : list) {
            res.append(s);
            if (c > d2) {
                for (int j = 0; j < d1; j++) {
                    res.append(" ");
                    c--;
                }
            }
        }
        if (d2 > 0) {
            for (int i = 0; i < d2; i++) {
                res.append(" ");
            }
        }
        return res.toString();

    }

    public List<String> fuck(String text) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);
            if (curr != ' ') {
                sb.append(curr);
            } else {
                if (sb.length() != 0) {
                    res.add(sb.toString().replace(" ", ""));
                    sb.setLength(0);
                }
            }
            if (i == text.length() - 1) {
                if (sb.length() != 0) {
                    res.add(sb.toString().replace(" ", ""));
                    sb.setLength(0);
                }
            }
        }
        return res;
    }

    public int count(String text) {

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
}
