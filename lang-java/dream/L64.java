/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/30 15:28
 **/
public class L64 {

    /**
     * 剑指 Offer #64 求1+2+…+n
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        if (n == 0) {
            return n;
        }
        return n + sumNums(n - 1);
    }
}
