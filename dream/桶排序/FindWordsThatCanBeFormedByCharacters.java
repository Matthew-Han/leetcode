package 桶排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 桶排序.FindWordsThatCanBeFormedByCharacters
 * @Description #1160 拼写单词
 * @Author MatthewHan
 * @Date 2020/7/7 11:11
 * @Version 1.0
 **/
public class FindWordsThatCanBeFormedByCharacters {

    /**
     * 桶排序
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 91.10% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param words
     * @param chars
     * @return
     */
    public static int countCharactersPro(String[] words, String chars) {
        int[] bucket = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            bucket[chars.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (String word : words) {
            // 这里不要用clone()方法，没这个快
            int[] temp = Arrays.copyOf(bucket, 26);
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (temp[index] - 1 < 0) {
                    flag = false;
                    break;
                } else {
                    temp[index]--;
                }
            }
            if (flag) {
                sum += word.length();
            }
        }
        return sum;

    }

    /**
     * 执行用时： 53 ms , 在所有 Java 提交中击败了 23.36% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsMap = new HashMap<>(chars.length() * 4 / 3 + 1);
        for (int i = 0; i < chars.length(); i++) {
            charsMap.put(chars.charAt(i), charsMap.getOrDefault(chars.charAt(i), 0) + 1);
        }
        int sum = 0;
        for (String word : words) {
            boolean flag = true;
            Map<Character, Integer> temp = new HashMap<>(charsMap);
            for (int i = 0; i < word.length(); i++) {
                int num = (null == temp.get(word.charAt(i)) ? 0 : temp.get(word.charAt(i)));
                if (num - 1 < 0) {
                    flag = false;
                    break;
                } else {
                    temp.put(word.charAt(i), temp.get(word.charAt(i)) - 1);
                }
            }
            if (flag) {
                sum += word.length();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countCharactersPro(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}
