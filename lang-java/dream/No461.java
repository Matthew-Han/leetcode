import java.util.Arrays;


/**
 * @ClassName HammingDistance
 * @Description #461 汉明距离
 * @Author MatthewHan
 * @Date 2020/5/17 02:28
 * @Version 1.0
 **/
public class No461 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 74.45% 的用户
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistanceXor(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += (x >> i & 1) ^ (y >> i & 1);
        }
        return ans;
    }

    /**
     * 执行用时 : 8 ms , 在所有 Java 提交中击败了 19.95% 的用户
     * 内存消耗 : 37.3 MB , 在所有 Java 提交中击败了 6.45% 的用户
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        String[] xBinary = Integer.toBinaryString(x).split("");
        String[] yBinary = Integer.toBinaryString(y).split("");
        int len = Math.max(xBinary.length, yBinary.length);
        Integer[] xTemp = new Integer[len];
        Integer[] yTemp = new Integer[len];
        int j = xBinary.length - 1;
        int k = yBinary.length - 1;
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            xTemp[i] = (j >= 0) ? Integer.parseInt(xBinary[j]) : 0;
            yTemp[i] = (k >= 0) ? Integer.parseInt(yBinary[k]) : 0;
            j--;
            k--;
            if (!xTemp[i].equals(yTemp[i])) {
                count++;
            }
        }
        return count;
    }
}
