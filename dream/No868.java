/**
 * @ClassName BinaryGap
 * @Description #868 二进制间距
 * @Author MatthewHan
 * @Date 2020/6/20 23:30
 * @Version 1.0
 **/
public class No868 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 80.67% 的用户
     * 内存消耗 : 36.7 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param n
     * @return
     */
    public static int binaryGap(int n) {
        String fucker = Integer.toBinaryString(n);
        int count = 0;
        int low = -1;
        int max = 0;
        System.out.println(fucker);
        for (int i = 0; i < fucker.length(); i++) {
            if (fucker.charAt(i) == '1') {
                if (count != 0) {
                    max = Math.max(max, i - low);
                }
                count++;
                low = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(8));
    }
}
