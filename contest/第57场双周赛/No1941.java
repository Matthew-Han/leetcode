package 第57场双周赛;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/26 09:54
 * @since 1.0
 **/
public class No1941 {

    /**
     * 检查是否所有字符出现次数相同
     *
     * @param s
     * @return
     */
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int prev = map.get(s.charAt(0));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != prev) {
                return false;
            }
            prev = entry.getValue();
        }
        return true;
    }
}
