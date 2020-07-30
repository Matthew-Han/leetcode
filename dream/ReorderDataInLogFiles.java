import java.util.Arrays;

/**
 * @ClassName ReorderDataInLogFiles
 * @Description #937 重新排列日志文件
 * @Author MatthewHan
 * @Date 2020/6/25 23:08
 * @Version 1.0
 **/
public class ReorderDataInLogFiles {

    /**
     * 执行用时： 12 ms , 在所有 Java 提交中击败了 18.66% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param logs
     * @return
     */
    public static String[] reorderLogFiles(String[] logs) {
        String[][] fucker = new String[logs.length][2];

        int start = 0;
        int end = logs.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            if (Character.isDigit(logs[i].charAt(logs[i].length() - 1))) {
                fucker[end][0] = logs[i];
                end--;
            } else {
                int index = logs[i].indexOf(' ');
                fucker[start][0] = logs[i].substring(0, index);
                fucker[start][1] = logs[i].substring(index + 1);
                start++;
            }
        }

        System.out.println("fucker = " + Arrays.deepToString(fucker));

        for (int i = 0; i < start - 1; i++) {
            for (int j = 0; j < start - 1 - i; j++) {
                String[] left = fucker[j];
                String[] right = fucker[j + 1];
                int condition = fuck(left[1], right[1]);
                // 后半段为不一样
                if (condition == 1) {
                    fucker[j] = right;
                    fucker[j + 1] = left;
                    // 当后半段一样时
                } else if (condition == 0) {
                    // 判断前半段是否需要交换
                    if (fuck(left[0], right[0]) == 1) {
                        fucker[j] = right;
                        fucker[j + 1] = left;
                    }
                }
            }
        }

        for (String[] strings : fucker) {
            System.out.println("strings = " + Arrays.toString(strings));
        }

        String[] result = new String[fucker.length];
        for (int i = 0; i < result.length; i++) {
            if (i < start) {
                result[i] = fucker[i][0] + " " + fucker[i][1];
            } else {
                result[i] = fucker[i][0];
            }
        }
        return result;
    }

    /**
     * 0 = 一样
     * 1 = 大
     * -1 = 小
     *
     * @param a
     * @param b
     * @return
     */
    public static int fuck(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return 1;
            } else if (a.charAt(i) < b.charAt(i)) {
                return -1;
            }
        }
        return Integer.compare(a.length(), b.length());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"})));
        System.out.println(fuck("aaaa cc", "aac s"));
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"let3 aaaa cc", "let3 aac s"})));


    }
}
