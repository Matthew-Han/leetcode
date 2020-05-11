import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    /**
     * 执行用时 : 40 ms , 在所有 Java 提交中击败了 8.59% 的用户
     * 内存消耗 : 40.4 MB , 在所有 Java 提交中击败了 8.33% 的用户
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
        System.out.println(map1);
        System.out.println(map2);
        int count = 0;
        for (String s1 : map1.keySet()) {
            for (String s2 : map2.keySet()) {
                if (s1.equals(s2) && map1.get(s1) <= map2.get(s2)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        return count == map1.size();
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "ag"));
    }
}
