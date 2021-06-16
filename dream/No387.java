import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName FirstUniqueCharacterInAstring
 * @Description #387 字符串中的第一个唯一字符
 * @Author MatthewHan
 * @Date 2020/5/12 10:04
 * @Version 1.0
 **/
public class No387 {

    /**
     * 执行用时 : 38 ms , 在所有 Java 提交中击败了 37.75% 的用户
     * 内存消耗 : 40.8 MB , 在所有 Java 提交中击败了 6.12% 的用户
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map1 = new LinkedHashMap<>(s.length() * 4 / 3 + 1);
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }
        Character key = null;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1) {
                key = entry.getKey();
                break;
            }
        }
        // 因为key是char的包装类，所以要判断是否为空，s.charAt(i)是原始类型，不能为空
        if (key != null) {
            for (int i = 0; i < s.length(); i++) {
                if (key == s.charAt(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar(" "));
    }
}
