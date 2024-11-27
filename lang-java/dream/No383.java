import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RansomNote
 * @Description #383 赎金信
 * @Author MatthewHan
 * @Date 2020/5/11 21:43
 * @Version 1.0
 **/
public class No383 {


    /**
     * 执行用时 : 15 ms , 在所有 Java 提交中击败了 30.25% 的用户
     * 内存消耗 : 40 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstructPro(String ransomNote, String magazine) {
        List<Character> list1 = new ArrayList<>(ransomNote.length());
        List<Character> list2 = new ArrayList<>(magazine.length());
        for (int i = 0; i < ransomNote.length(); i++) {
            list1.add(ransomNote.charAt(i));
        }
        for (int i = 0; i < magazine.length(); i++) {
            list2.add(magazine.charAt(i));
        }
        for (int i = list1.size() - 1; i >= 0; i--) {
            for (int i1 = list2.size() - 1; i1 >= 0; i1--) {
                if (list1.get(i).equals(list2.get(i1))) {
                    list1.remove(i);
                    list2.remove(i1);
                    break;
                }
            }
        }
        return list1.isEmpty();
    }

    /**
     * 执行用时 : 40 ms , 在所有 Java 提交中击败了 8.59% 的用户
     * 内存消耗 : 40.4 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> map1 = new HashMap<>(ransomNote.length() * 4 / 3 + 1);
        Map<String, Integer> map2 = new HashMap<>(magazine.length() * 4 / 3 + 1);
        for (int i = 0; i < ransomNote.length(); i++) {
            map1.put(String.valueOf(ransomNote.charAt(i)), map1.getOrDefault(String.valueOf(ransomNote.charAt(i)), 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            map2.put(String.valueOf(magazine.charAt(i)), map2.getOrDefault(String.valueOf(magazine.charAt(i)), 0) + 1);
        }
        int count = 0;
        for (String s1 : map1.keySet()) {
            for (String s2 : map2.keySet()) {
                if (s1.equals(s2) && map1.get(s1) <= map2.get(s2)) {
                    count++;
                    break;
                }
            }
        }
        return count == map1.size();
    }
}
