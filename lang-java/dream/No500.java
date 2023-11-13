import java.util.*;

/**
 * @ClassName KeyboardRow
 * @Description #500 键盘行
 * @Author MatthewHan
 * @Date 2020/5/18 17:00
 * @Version 1.0
 **/
public class No500 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 55.74% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 12.50% 的用户
     *
     * @param words
     * @return
     */
    public static String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>(4);
        char[] first = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] second = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] third = {'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        for (char c : first) {
            map.put(c, 1);
        }
        for (char c : second) {
            map.put(c, 2);
        }
        for (char c : third) {
            map.put(c, 3);
        }

        List<String> list = new ArrayList<>(words.length);
        for (String word : words) {
            int j = 0;
            int count = 0;
            int layer = map.get(word.charAt(j));
            for (; j < word.length(); j++) {
                if (layer == map.get(word.charAt(j))) {
                    count++;
                }
            }
            if (count == word.length()) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace", "Hash"})));
    }
}
