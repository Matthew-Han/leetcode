package 位运算;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/26 10:30
 * @since 1.0
 **/
public class No371 {

    /**
     * 两整数之和
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int p = a >> i & 1;
            int q = b >> i & 1;
            if (p == 1 && q == 1) {
                sb.insert(0, carry ? 1 : 0);
                carry = true;
            } else if (p == 1 || q == 1) {
                sb.insert(0, carry ? 0 : 1);
            } else {
                sb.insert(0, carry ? 1 : 0);
                carry = false;
            }
        }
        return (int) Long.parseLong(sb.toString(), 2);
    }
}
