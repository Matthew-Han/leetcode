package 双指针;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/13 10:43 13
 * @since 1.0
 **/
public class M0105 {

    /**
     * 一次编辑
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length() + 1) {
            return fuck(second, first);
        } else if (first.length() + 1 == second.length()) {
            return fuck(first, second);
        } else if (first.length() == second.length()) {
            int cnt = 0;
            for (int i = 0; i < first.length(); i++) {
                cnt += first.charAt(i) != second.charAt(i) ? 1 : 0;
            }
            return cnt <= 1;
        }
        return false;
    }

    public boolean fuck(String l, String r) {
        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < l.length()) {
            if (l.charAt(i) != r.charAt(j)) {
                cnt++;
                i--;
            }
            i++;
            j++;
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }
}
