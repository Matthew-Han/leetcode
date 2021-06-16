import java.util.*;

/**
 * @ClassName UncommonWordsFromTwoSentences
 * @Description #884 两句话中的不常见单词
 * @Author MatthewHan
 * @Date 2020/6/22 00:40
 * @Version 1.0
 **/
public class No884 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 10.00% 的用户
     * <p>
     * 改成如下（a + b的情况）更简洁，但是变得更慢
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 20.39% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static String[] uncommonFromSentences(String a, String b) {
        Map<String, Integer> map = new HashMap<>((a.length() + b.length()) * 4 / 3 + 1);
        String[] arr = (a + " " + b).split(" ");
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println("map = " + map);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("apple apple", "fuck")));
    }
}
