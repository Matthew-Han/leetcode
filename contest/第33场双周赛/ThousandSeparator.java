package 第33场双周赛;

/**
 * @ClassName thousandSeparator
 * @Description #5479 千位分隔数
 * @Author MatthewHan
 * @Date 2020/8/22 22:18
 * @Version 1.0
 **/
public class ThousandSeparator {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static String thousandSeparator(int n) {
        String tmp = String.valueOf(n);
        StringBuilder sb = new StringBuilder(tmp);
        sb.reverse();
        for (int i = 3; i < sb.length(); i += 4) {
            sb.insert(i, ".");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(1111));
        System.out.println(thousandSeparator(1232323233));
        System.out.println(thousandSeparator(232323233));
        System.out.println(thousandSeparator(2333));
        System.out.println(thousandSeparator(2));
        System.out.println(thousandSeparator(0));

    }
}
