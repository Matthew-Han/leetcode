/**
 * @ClassName DeepDarkFraction
 * @Description #LCP 02 分式化简
 * @Author MatthewHan
 * @Date 2020/7/15 17:54
 * @Version 1.0
 **/
public class Lcp02 {

    public int[] fraction(int[] cont) {
        int[] ans = {1, cont[cont.length - 1]};
        for (int i = cont.length - 2; i >= 0; i--) {
            int n = cont[i];
            ans = new int[]{ans[1], ans[0] + n * ans[1]};
        }
        ans[0] ^= ans[1];
        ans[1] ^= ans[0];
        ans[0] ^= ans[1];
        int x = gcd(ans[0], ans[1]);
        return new int[]{ans[0] / x, ans[1] / x};
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
