import java.util.Arrays;

/**
 * @ClassName DiStringMatch
 * @Description #942 增减字符串匹配
 * @Author MatthewHan
 * @Date 2020/6/26 17:19
 * @Version 1.0
 **/
public class No942 {

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 84.82% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param s
     * @return
     */
    public static int[] diStringMatch(String s) {
        int len = s.length();
        int[] result = new int[len + 1];
        int min = 0;
        int max = s.length();

        for (int i = 0; i < len; i++) {
            if ('I' == s.charAt(i)) {
                result[i] = min;
                min++;
            } else {
                result[i] = max;
                max--;
            }
        }
        result[len] = min;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDIDDDI")));
    }
}
