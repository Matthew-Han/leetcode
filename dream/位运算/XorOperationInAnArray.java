package 位运算;

/**
 * @ClassName 位运算.XorOperationInAnArray
 * @Description #1486 数组异或操作
 * @Author MatthewHan
 * @Date 2020/7/15 14:41
 * @Version 1.0
 **/
public class XorOperationInAnArray {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
        int temp = start;
        for (int i = 1; i < n; i++) {
            temp ^= (start + 2 * i);
        }

        return temp;

    }

    public static void main(String[] args) {
        System.out.println(1 ^ 0);
        System.out.println(2 ^ 10);
    }

}
