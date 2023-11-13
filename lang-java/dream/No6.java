import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/1 12:31 01
 * @since 1.0
 **/
public class No6 {

    /**
     * Z 字形变换
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        Map<Integer, List<Character>> map = new TreeMap<>();
        int layer = 1;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            List<Character> row = map.getOrDefault(layer, new ArrayList<>());
            row.add(s.charAt(i));
            map.put(layer, row);
            layer += flag ? 1 : -1;
            flag = layer != numRows && (layer == 1 || flag);
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((k, v) -> v.forEach(sb::append));
        return sb.toString();
    }
}
