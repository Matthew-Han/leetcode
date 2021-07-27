package 第55场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/28 14:13
 * @since 1.0
 **/
public class No1910 {

    /**
     * #1910 删除一个字符串中所有出现的给定子字符串
     *
     * @param s
     * @param part
     * @return
     */
    public String removeOccurrences(String s, String part) {
        int prev = s.length();
        while (s.length() > 0) {
            s = s.replaceFirst(part, "");
            if (s.length() == prev) {
                break;
            }
            prev = s.length();
        }
        return s;
    }

    public static void main(String[] args) {
        int nas = 0;
        fuck:
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            nas = i;
            if (nas == 3) {
                break fuck;
            }
        }
        System.out.println("nas = " + nas);
    }
}

