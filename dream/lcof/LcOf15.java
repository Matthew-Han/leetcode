package lcof;

/**
 * @ClassName LcOf15
 * @Description 剑指 Offer #15 二进制中1的个数
 * @Author MatthewHan
 * @Date 2020/7/18 23:59
 * @Version 1.0
 **/
public class LcOf15 {

    public static int hammingWeight(int n) {
        String temp = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.28% 的用户
     * 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int hammingWeightPro(int n) {
        int count = 0;
        while (n != 0) {
            // 相当于判断奇偶
            count += n & 0x1;
            n = n >>> 1;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-3).length());
        System.out.println(-99 << 2);
        System.out.println(hammingWeightPro(-123442412));
        System.out.println(hammingWeight(-123442412));
    }
}
