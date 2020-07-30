import java.util.*;

/**
 * @ClassName MostCommonWord
 * @Description #819 最常见的单词
 * @Author MatthewHan
 * @Date 2020/6/18 11:28
 * @Version 1.0
 **/
public class MostCommonWord {

    /**
     * 执行用时 : 19 ms , 在所有 Java 提交中击败了 33.27% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("\\pP|\\pS", " ");
        System.out.println(paragraph);
        paragraph = paragraph.toLowerCase();
        String[] result = paragraph.split(" ");
        System.out.println(Arrays.toString(result));
        Map<String, Integer> map = new HashMap<>();
        for (String s : result) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // 过滤违禁词
        for (String s : banned) {
            map.entrySet().removeIf(item -> item.getKey().equals(s));
        }
        // 过滤key=""
        map.remove("");
        List<Integer> list = new ArrayList<>(map.size());
        list.addAll(map.values());
        Collections.sort(list);
        Integer maxValue = list.get(list.size() - 1);

        System.out.println(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                return entry.getKey();
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob. hIt, baLl", new String[]{"hit"}));
    }
}
