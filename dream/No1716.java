/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/17 09:18
 * @since 1.0
 **/
public class No1716 {

    /**
     * 计算力扣银行的钱
     *
     * @param n
     * @return
     */
    public int totalMoney(int n) {
        int ans = 0;
        int weeks = n / 7;
        int days = n % 7;
        return (weeks >= 1 ? weeks * 28 + weeks * (weeks - 1) / 2 * 7 : 0) + days * (weeks + 1) + days * (days - 1) / 2;
    }
}
