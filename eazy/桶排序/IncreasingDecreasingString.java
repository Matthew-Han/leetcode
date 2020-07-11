package 桶排序;

/**
 * @ClassName IncreasingDecreasingString
 * @Description #1370 上升下降字符串
 * @Author MatthewHan
 * @Date 2020/7/12 02:08
 * @Version 1.0
 **/
public class IncreasingDecreasingString {

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 56.29% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static String sortString(String s) {
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();

        // 字符串剩余个数
        int sum = s.length();
        // 指针缓存，不必每次遍历都是bucket的长度大小
        int start = 0;
        int end = bucket.length - 1;
        while (sum > 0) {
            for (int i = start; i < bucket.length; i++) {
                if (bucket[i] - 1 >= 0) {
                    bucket[i]--;
                    sum--;
                    result.append((char) (i + 'a'));
                }
                if (start == i && bucket[i] == 0) {
                    start++;
                }
            }
            for (int i = end; i >= 0; i--) {
                if (bucket[i] - 1 >= 0) {
                    bucket[i]--;
                    sum--;
                    result.append((char) (i + 'a'));
                }
                if (end == i && bucket[i] == 0) {
                    end--;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
        System.out.println("abccbaabccba");
    }

}
