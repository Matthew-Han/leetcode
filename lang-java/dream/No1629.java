import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/10 09:40
 * @since 1.0
 **/
public class No1629 {

    /**
     * 按键持续时间最长的键
     *
     * @param releaseTimes
     * @param keysPressed
     * @return
     */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = 0;
        char ans = 'a';
        TreeMap<Character, Integer> map = new TreeMap<>((o1, o2) -> Integer.compare(o1, o2));
        for (int i = 0; i < keysPressed.length(); i++) {
            map.put(keysPressed.charAt(i), Math.max(map.getOrDefault(keysPressed.charAt(i), 0), releaseTimes[i] - (i - 1 >= 0 ? releaseTimes[i - 1] : 0)));
            max = Math.max(max, map.get(keysPressed.charAt(i)));
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == max) {
                ans = e.getKey();
            }
        }
        return ans;
    }
}
