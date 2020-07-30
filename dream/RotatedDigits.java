/**
 * @ClassName RotatedDigits
 * @Description #788 旋转数字
 * @Author MatthewHan
 * @Date 2020/6/17 14:18
 * @Version 1.0
 **/
public class RotatedDigits {

    /**
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 64.41% 的用户
     * 内存消耗 : 36.5 MB , 在所有 Java 提交中击败了 50.00% 的用户
     * <p>
     * 二种情况：
     * 1. 当数字含有3、4、7，直接GG
     * 2. 当数字不包含任何2、5、6、9，直接GG
     *
     * @param n
     * @return
     */
    public static int rotatedDigits(int n) {

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (isGoodNumber(i)) {
                sum++;
            }
        }
        return sum;

    }

    public static boolean isGoodNumber(int n) {
        boolean belong = false;
        while (n > 0) {
            int temp = n % 10;
            if (temp == 3 || temp == 4 || temp == 7) {
                return false;
            } else if (temp == 2 || temp == 5 || temp == 6 || temp == 9) {
                belong = true;
            }
            n /= 10;
        }
        return belong;
    }

    public static void main(String[] args) {
        System.out.println(rotatedDigits(9999));
    }
}
