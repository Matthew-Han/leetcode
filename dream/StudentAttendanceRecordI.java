import java.util.Map;

/**
 * @ClassName StudentAttendanceRecordI
 * @Description #551. 学生出勤记录 I
 * @Author MatthewHan
 * @Date 2020/5/20 15:09
 * @Version 1.0
 **/
public class StudentAttendanceRecordI {

    /**
     * indexOf 是查某个指定的字符串在字符串首次出现的位置（索引值）（从左往右）
     * lastIndexOf 是查某个指定的字符串在字符串最后一次出现的位置（索引值）（从右往左）
     * 当两者不一致的时候，说明必有多个~
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.6 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param s
     * @return
     */
    public static boolean checkRecordPro(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 60.54% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param s
     * @return
     */
    public static boolean checkRecord(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c == 'A' ? 1 : 0;
        }
        if (count > 1) {
            return false;
        }
        return !s.contains("LLL");
    }

    /**
     * 执行用时 : 153 ms , 在所有 Java 提交中击败了 5.56% 的用户
     * 内存消耗 : 40.3 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param s
     * @return
     */
    public static boolean checkRecordWorse(String s) {
        int count = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            count += s.toCharArray()[i] == 'A' ? 1 : 0;
            if (i + 2 < s.length()) {
                int fucker = (s.toCharArray()[i] + s.toCharArray()[i + 1] + s.toCharArray()[i + 2]);
                if (fucker == 76 * 3) {
                    return false;
                }
            }
        }
        return count <= 1;
    }



    public static void main(String[] args) {
        System.out.println(checkRecordWorse("LLLPLLALL"));

    }
}
