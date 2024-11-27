/**
 * @ClassName CompressString
 * @Description 面试题 01.06. 字符串压缩
 * @Author MatthewHan
 * @Date 2020/7/23 15:15
 * @Version 1.0
 **/
public class M0106 {


    /**
     * 双指针
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 74.32% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static String compressString2(String s) {
        int j = 1;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            System.out.println("curr = " + curr);
            sb.append(curr);
            while (j < s.length() && s.charAt(j) == curr) {
                j++;
                count++;
            }
            sb.append(count);
            // 初始化指针
            i = j - 1;
            // 初始化计数器
            count = 1;
            j = i + 2;
            // 或者直接 count = 0;
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 37.22% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static String compressString(String s) {
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        boolean isAdd = true;
        int currCount = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            char curr = s.charAt(i);
            if (isAdd) {
                sb.append(curr);
                if (curr == s.charAt(i + 1)) {
                    isAdd = false;
                } else {
                    sb.append(currCount);
                    currCount = 1;
                }
            } else {
                currCount++;
                if (curr != s.charAt(i + 1)) {
                    isAdd = true;
                    sb.append(currCount);
                    currCount = 1;
                }
            }
            if (i == len - 2 && curr == s.charAt(i + 1)) {
                currCount++;
                sb.append(currCount);
            } else if (i == len - 2 && curr != s.charAt(i + 1)) {
                sb.append(s.charAt(i + 1)).append(1);
            }
        }
        return sb.length() < len ? sb.toString() : s;
    }
}
