/**
 * @ClassName ReverseBits
 * @Description 面试题 05.03. 翻转数位
 * @Author MatthewHan
 * @Date 2020/7/27 11:36
 * @Version 1.0
 **/
public class M0503 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param num
     * @return
     */
    public static int reverseBits(int num) {
        String binary = Integer.toBinaryString(num);
        System.out.println("binary = " + binary);
        int oneCount = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                oneCount++;
            }
        }
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        int left = 0;
        int right;
        for (int i = 1; i < binary.length() - 1; i++) {
            if (binary.charAt(i) == '0') {
                flag = true;
                right = i + 1;
                while (right < binary.length()) {
                    if (binary.charAt(right) == '0') {
                        break;
                    }
                    right++;
                }

                max = Math.max(max, right - left);
                left = i + 1;
            }
        }
        // binary 肯定有 0
        return flag ? max : oneCount + 1;

    }
}
