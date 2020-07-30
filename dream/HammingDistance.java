import java.util.Arrays;


/**
 * @ClassName HammingDistance
 * @Description #461 汉明距离
 * @Author MatthewHan
 * @Date 2020/5/17 02:28
 * @Version 1.0
 **/
public class HammingDistance {

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
            System.out.println(j);
            System.out.println(k);
            xTemp[i] = (j >= 0) ? Integer.parseInt(xBinary[j]) : 0;
            yTemp[i] = (k >= 0) ? Integer.parseInt(yBinary[k]) : 0;
            j--;
            k--;
            if (!xTemp[i].equals(yTemp[i])) {
                count++;
            }
        }
        System.out.println("xTemp = " + Arrays.toString(xTemp));
        System.out.println("yTemp = " + Arrays.toString(yTemp));

        return count;

    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 44));

    }
}
