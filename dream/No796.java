/**
 * @ClassName RotateString
 * @Description #796 旋转字符串
 * @Author MatthewHan
 * @Date 2020/6/17 14:45
 * @Version 1.0
 **/
public class No796 {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean rotateString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        return (a + a).contains(b);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("ddee", "eeee"));
    }
}
