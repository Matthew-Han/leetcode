/**
 * @ClassName FactorialZeros
 * @Description 面试题 16.05. 阶乘尾数
 * @Author MatthewHan
 * @Date 2020/7/29 09:10
 * @Version 1.0
 **/
public class M1605 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.37% 的用户
     * 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
