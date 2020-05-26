import java.util.Arrays;

public class Temp2 {

    public static int countBinarySubstringsPro(String s) {
        int len = s.length();
        int size = 0;
        while (size<=len) {
            int i = 0;
            int j = i + size - 1;
            for ( ; j < len; i++, j++) {
                System.out.println(s.substring(i, j + 1));
            }
            size += 2;
        }
        return 0;
    }
    /**
     * 超出时间限制
     * @param s
     * @return
     */
    public static int countBinarySubstrings(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            int c = 1;
            char point = s.charAt(i);
            boolean go = true;
            for (; j < len; j++) {
                if (go && point == s.charAt(j)) {
                    c++;
                } else {
                    go = false;
                    if (point == s.charAt(j)) {
                        break;
                    }
                    if (j  >= (i - 1 + c * 2)) {
                        count++;
                        break;
                    }
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstringsPro("00111001010110001011"));
    }
}
