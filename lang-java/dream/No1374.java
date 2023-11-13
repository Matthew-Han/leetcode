/**
 * @ClassName GenerateAstringWithCharactersThatHaveOddCounts
 * @Description #1374 生成每种字符都是奇数个的字符串
 * @Author MatthewHan
 * @Date 2020/7/12 05:31
 * @Version 1.0
 **/
public class No1374 {

    /**
     * 判断奇偶就可以了
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.01% 的用户
     * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public String generateTheString(int n) {
        StringBuilder result = new StringBuilder();
        if ((n & 1) == 0) {
            result.append("a");
            for (int i = 0; i < n - 1; i++) {
                result.append("b");
            }
        } else {
            for (int i = 0; i < n; i++) {
                result.append("a");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
