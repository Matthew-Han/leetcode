/**
 * @ClassName ConsecutiveCharacters
 * @Description #1446 连续字符
 * @Author MatthewHan
 * @Date 2020/7/14 17:13
 * @Version 1.0
 **/
public class No1446 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 47.14% 的用户
     * 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static int maxPower(String s) {
        // 加个哨兵
        // s += 0;
        int max = 1;
        int curr = 1;
        int currEle = s.charAt(0);
        for (int i = 0; i < s.length() - 1; i++) {
            char next = s.charAt(i + 1);
            if (currEle == next) {
                curr++;
            } else {
                max = Math.max(max, curr);
                currEle = next;
                curr = 1;
            }
            // 最后一位
            if (i == s.length() - 2) {
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("lee"));
    }
}
