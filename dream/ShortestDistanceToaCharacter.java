import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ShortestDistanceToaCharacter
 * @Description #821 字符的最短距离
 * @Author MatthewHan
 * @Date 2020/6/18 22:28
 * @Version 1.0
 **/
public class ShortestDistanceToaCharacter {

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 68.20% 的用户
     * 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 9.09% 的用户
     *
     * @param s
     * @param c
     * @return
     */
    public static int[] shortestToCharPro(String s, char c) {
        int prev = s.length() - 1;
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.abs(prev - i);
        }
        int next = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                next = i;
            }
            result[i] = Math.min(Math.abs(next - i), result[i]);
        }
        return result;
    }

    /**
     * 行用时 : 8 ms , 在所有 Java 提交中击败了 19.11% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 9.09% 的用户
     *
     * @param s
     * @param c
     * @return
     */
    public static int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }
        if (list.size() == 1) {
            int index = list.get(0);
            int[] result = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                result[i] = Math.abs(index - i);
            }
            return result;
        }
        int index = -1;
        int[] result = new int[s.length()];
        for (int k = 0; k < s.length(); k++) {

            if (s.charAt(k) == c) {
                index++;
            }
            int minE = Integer.MAX_VALUE;
            for (int i = index; i < list.size(); i++) {
                int cE = list.get(i == -1 ? 0 : i);
                minE = Math.min(minE, Math.abs(cE - k));
            }
            result[k] = minE;


        }
        System.out.println("result = " + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToCharPro("loveleetcodeandfuckit", 'e')));
    }
}
