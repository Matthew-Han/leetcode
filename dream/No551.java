/**
 * @ClassName StudentAttendanceRecordI
 * @Description #551. 学生出勤记录 I
 * @Author MatthewHan
 * @Date 2020/5/20 15:09
 * @Version 1.0
 **/
public class No551 {

    /**
     * indexOf 是查某个指定的字符串在字符串首次出现的位置（索引值）（从左往右）
     * lastIndexOf 是查某个指定的字符串在字符串最后一次出现的位置（索引值）（从右往左）
     * 当两者不一致的时候，说明必有多个~
     * <p>
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.6 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param s
     * @return
     */
    public static boolean checkRecord3(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 60.54% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param s
     * @return
     */
    public static boolean checkRecord2(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c == 'A' ? 1 : 0;
        }
        return count <= 1 && !s.contains("LLL");
    }

    public boolean checkRecord(String s) {
        int cnt = s.charAt(0) == 'A' ? 1 : 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'L' && s.charAt(i - 1) == s.charAt(i) && s.charAt(i + 1) == s.charAt(i)) {
                return false;
            }
            cnt += s.charAt(i) == 'A' ? 1 : 0;
        }
        cnt += s.length() == 1 ? 0 : s.charAt(s.length() - 1) == 'A' ? 1 : 0;
        return cnt < 2;
    }

}
