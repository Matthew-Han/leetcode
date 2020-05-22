import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName MinimumIndexSumOfTwoLists
 * @Description #599 两个列表的最小索引总和
 * @Author MatthewHan
 * @Date 2020/5/22 14:05
 * @Version 1.0
 **/
public class MinimumIndexSumOfTwoLists {

    /**
     * 执行用时 : 33 ms , 在所有 Java 提交中击败了 25.87% 的用户
     * 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param list1
     * @param list2
     * @return
     */
    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> son = new HashMap<>(list1.length * 4 / 3 + 1);
        Map<String, Integer> index = new HashMap<>(list1.length * 4 / 3 + 1);

        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
            son.put(list1[i], son.getOrDefault(list1[i], 0) + 1);
        }
        for (int i = 0; i < list2.length; i++) {
            index.put(list2[i], index.getOrDefault(list2[i], index.get(list2[i]) == null ? 0 : index.get(list2[i])) + i);
            son.put(list2[i], son.getOrDefault(list2[i], 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : son.entrySet()) {
            if (entry.getValue() >= 2) {
                list.add(entry.getKey());
            }
        }
        Map<String, Integer> indexMap = new HashMap<>(list.size() * 4 / 3 + 1);
        int min = Integer.MAX_VALUE;
        for (String s : list) {
            if (index.get(s) != null) {
                indexMap.put(s, index.get(s));
                min = Math.min(min, index.get(s));
            }
        }
        List<String> result = new ArrayList(indexMap.size());
        for (Map.Entry<String, Integer> entry : indexMap.entrySet()) {
            if (entry.getValue() == min) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRestaurant(new String[]{"KFC", "ff", "Fucker", "dd"}, new String[]{"Fucker", "KFC", "dd"})));

    }
}
