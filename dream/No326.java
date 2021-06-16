/**
 * @ClassName PowerOfThree
 * @Description #326 3的幂
 * @Author MatthewHan
 * @Date 2020/5/9 09:19
 * @Version 1.0
 **/
public class No326 {

    /**
     * 执行用时 : 16 ms , 在所有 Java 提交中击败了 53.78% 的用户
     * 内存消耗 : 38.9 MB , 在所有 Java 提交中击败了 8.70% 的用户
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        while (n / 3 > 0) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(0 % 3);
    }
}
