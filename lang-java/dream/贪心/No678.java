package 贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/14 16:50
 * @since 1.0
 **/
public class No678 {

    /**
     * 有效的括号字符串
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        List<Character> src = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                src.add(curr);
            } else if (curr == '*') {
                src.add(curr);
            } else {
                if (src.isEmpty()) {
                    return false;
                }
                if (src.get(src.size() - 1) == '(') {
                    src.remove(src.size() - 1);
                } else {
                    src.add(curr);
                }
            }
        }
        if (src.isEmpty()) {
            return true;
        }
        List<Character> tmp = new ArrayList<>(src);
        boolean flag = Collections.replaceAll(tmp, '*', '(');
        if (!flag) {
            return false;
        }
        int cnt = 0;
        for (Character character : tmp) {
            cnt += character == '(' ? 1 : -1;
            if (cnt < 0) {
                return false;
            }
        }
        tmp = new ArrayList<>(src);
        Collections.replaceAll(tmp, '*', ')');
        cnt = 0;
        for (int i = tmp.size() - 1; i >= 0; i--) {
            cnt += tmp.get(i) == ')' ? 1 : -1;
            if (cnt < 0) {
                return false;
            }
        }
        return true;
    }

}
