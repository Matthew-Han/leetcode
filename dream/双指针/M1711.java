package 双指针;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FindClosest
 * @Description 面试题 17.11. 单词距离
 * @Author MatthewHan
 * @Date 2020/8/7 21:18
 * @Version 1.0
 **/
public class M1711 {

    /**
     * 执行用时： 12 ms , 在所有 Java 提交中击败了 95.22% 的用户
     * 内存消耗： 48.2 MB , 在所有 Java 提交中击败了 72.93% 的用户
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public static int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    min = Math.min(min, Math.abs(index1 - index2));
                }
            }
            if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    min = Math.min(min, Math.abs(index1 - index2));
                }
            }
        }
        return min;

    }

    public static void main(String[] args) {
        System.out.println(findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"},
                "a", "student"));
    }


}
