package 桶排序;

import java.util.Arrays;

/**
 * @ClassName 桶排序.CompareStringsByFrequencyOfTheSmallestCharacter
 * @Description #1170 比较字符串最小字母出现频次
 * @Author MatthewHan
 * @Date 2020/7/7 13:13
 * @Version 1.0
 **/
public class No1170 {

    /**
     * 老桶排了
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 74.07% 的用户
     * 内存消耗： 40.6 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param arg
     * @return
     */
    public static int f(String arg) {
        int[] bucket = new int[26];
        for (int i = 0; i < arg.length(); i++) {
            bucket[arg.charAt(i) - 'a']++;
        }
        for (int i : bucket) {
            if (i > 0) {
                return i;
            }
        }
        return 0;
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] queriesInt = new int[queries.length];
        int[] wordsInt = new int[words.length];
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queriesInt[i] = f(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            wordsInt[i] = f(words[i]);
        }

        Arrays.sort(wordsInt);
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = wordsInt.length - 1; j >= 0; j--) {
                if (queriesInt[i] < wordsInt[j]) {
                    count++;
                } else {
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[]{"bbb", "cc", "cc", "cc", "cc", "ccccccccccccccc"}, new String[]{"a", "aa", "aaa", "aaaa", "aaaaaaaa"})));
    }
}
