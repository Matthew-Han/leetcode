/**
 * @ClassName CountPrimes
 * @Description #204 计数质数
 * @Author MatthewHan
 * @Date 2020/8/4 17:07
 * @Version 1.0
 **/
public class No204 {

    public static int countPrimes(int n) {
        int result = 0;
        // 初始化默认值都为 false，为质数标记
        boolean[] b = new boolean[n];
        if (2 < n) {
            // 如果大于 2 则一定拥有 2 这个质数
            result++;
        }

        // 从 3 开始遍历，且只遍历奇数
        for (int i = 3; i < n; i += 2) {
            if (!b[i]) {
                // 是质数
                for (int j = 3; i * j < n; j += 2) {
                    // 将当前质数的奇数倍都设置成非质数标记 true
                    b[i * j] = true;
                }
                result++;   // 质数个数 +1
            }
        }
        return result;
    }


}
