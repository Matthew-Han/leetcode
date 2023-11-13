package 桶排序;

import java.util.Arrays;

/**
 * @ClassName 桶排序.MaximumNumberOfBalloons
 * @Description #1189 “气球” 的最大数量
 * @Author MatthewHan
 * @Date 2020/7/7 17:21
 * @Version 1.0
 **/
public class No1189 {

    /**
     * 修改版桶排序，反而更慢了。。
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 31.20% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param text
     * @return
     */
    public static int maxNumberOfBalloons(String text) {
        int[] bucket = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char temp = text.charAt(i);
            if (temp == 'a') {
                bucket[0]++;
            } else if (temp == 'b') {
                bucket[1]++;
            } else if (temp == 'l') {
                bucket[2]++;
            } else if (temp == 'o') {
                bucket[3]++;
            } else if (temp == 'n') {
                bucket[4]++;
            }
        }
        // l 和 n 是双倍的快乐
        bucket[2] /= 2;
        bucket[3] /= 2;
        Arrays.sort(bucket);
        return bucket[0];

    }

    /**
     * 经典桶排序
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param text
     * @return
     */
    public static int maxNumberOfBalloonsPro(String text) {
        int[] letters = new int[26];
        for (char ch : text.toCharArray()) {
            letters[ch - 'a']++;
        }
        letters['l' - 'a'] /= 2;
        letters['o' - 'a'] /= 2;
        int min = Integer.MAX_VALUE;
        for (char ch : "balon".toCharArray()) {
            if (letters[ch - 'a'] < min) {
                min = letters[ch - 97];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloonsPro("loonbalxballpoon"));
    }
}
