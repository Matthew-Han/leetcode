public class Temp {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 35.24% 的用户
     * 内存消耗 : 36 MB , 在所有 Java 提交中击败了 14.29% 的用户
     * @param n
     * @return
     */
    public static boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        int i = 0;
        int j = 1;
        while (j<str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        hasAlternatingBits(66);
    }
}
