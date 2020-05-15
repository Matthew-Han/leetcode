import java.util.Arrays;

/**
 * @ClassName AssignCookies
 * @Description #455 分发饼干
 * @Author MatthewHan
 * @Date 2020/5/15 17:37
 * @Version 1.0
 **/
public class AssignCookies {

    /**
     * 双指针
     * 花了7分钟做出来，leetcode的最速传说
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 45.47% 的用户
     * 内存消耗 : 40.7 MB , 在所有 Java 提交中击败了 9.52% 的用户
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; j < s.length; j++) {
            if (i < g.length && s[j] >= g[i]) {
                count++;
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
