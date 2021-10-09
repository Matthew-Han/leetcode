package 滑动窗口;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/9 09:04
 * @since 1.0
 **/
public class No187 {

    /**
     * 重复的DNA序列
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        Set<String> tmp = new HashSet<>();
        Set<String> vis = new HashSet<>();
        StringBuilder sb = new StringBuilder("-" + s.substring(0, 9));
        for (int i = 1; i < s.length() - 8; i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i + 8));
            if (vis.contains(sb.toString())) {
                tmp.add(sb.toString());
            }
            vis.add(sb.toString());
        }

        return new ArrayList<>(tmp);
    }
}
