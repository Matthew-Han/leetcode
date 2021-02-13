/**
 * @ClassName VerifyingAnAlienDictionary
 * @Description #953 验证外星语词典
 * @Author MatthewHan
 * @Date 2020/6/28 11:03
 * @Version 1.0
 **/
public class VerifyingAnAlienDictionary {

    /**
     * #953 验证外星语词典
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 44.34% 的用户
     * 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 82.48% 的用户
     *
     * @param words
     * @param order
     * @return
     */
    public static boolean isAlienSorted(String[] words, String order) {
        int max = 0;
        for (String word : words) {
            max = Math.max(max, word.length());
        }
        for (int i = 0; i < max; i++) {
            // 如果这一轮出现了相同的字符则要下一轮在判断了,除非出现了前者 大于 后者的情况可以直接 return false
            boolean flag = false;
            int prevIndex;
            if (i >= words[0].length()) {
                prevIndex = -1;
            } else {
                char prev = words[0].charAt(i);
                prevIndex = order.indexOf(String.valueOf(prev));
            }
            for (int j = 1; j < words.length; j++) {
                int currIndex;
                if (i >= words[j].length()) {
                    currIndex = -1;
                } else {
                    char curr = words[j].charAt(i);
                    currIndex = order.indexOf(String.valueOf(curr));
                }
                if (prevIndex > currIndex) {
                    return false;
                } else if (prevIndex == currIndex) {
                    flag = true;
                }
                prevIndex = currIndex;

            }
            if (!flag) {
                return true;
            }
        }
        return true;
    }

    /**
     * 官方题解
     *
     * @param words
     * @param order
     * @return
     */
    public static boolean isAlienSortedOfficial(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }

        search:
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']) {
                        return false;
                    }
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length()) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println("aabaa".indexOf('b'));
        System.out.println(isAlienSorted(new String[]{"kuvp", "k"}, "qkuvp"));
    }
}
