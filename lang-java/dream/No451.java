import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/3 13:27
 * @since 1.0
 **/
public class No451 {

    /**
     * #451 根据字符出现频率排序
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cache.put(s.charAt(i), cache.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(cache.entrySet());
        list.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
