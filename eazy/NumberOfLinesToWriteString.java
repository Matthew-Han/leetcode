import java.util.Arrays;

/**
 * @ClassName NumberOfLinesToWriteString
 * @Description #806 写字符串需要的行数
 * @Author MatthewHan
 * @Date 2020/6/17 15:22
 * @Version 1.0
 **/
public class NumberOfLinesToWriteString {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 53.20% 的用户
     * 内存消耗 : 37.9 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param widths
     * @param s
     * @return
     */
    public static int[] numberOfLines(int[] widths, String s) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (x + widths[s.charAt(i) - 'a'] > 100) {
                x = 0;
                y++;
            }
            x += widths[s.charAt(i) - 'a'];
        }
        int sum = (y * 100 + x);
        System.out.println("needPoint = " + sum);
        return new int[]{y + 1, x};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                "abcdefghijklmnopqrstuvwxyz")));
    }
}
