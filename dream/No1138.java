import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/10/29 17:47
 **/
public class No1138 {

    /**
     * #1138 字母板上的路径
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 28.78% 的用户
     * 内存消耗： 37.2 MB , 在所有 Java 提交中击败了 17.49% 的用户
     *
     * @param target
     * @return
     */
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        String[] dictionary = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        Map<Character, int[]> map = new HashMap<>(2 << 6);
        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < dictionary[i].length(); j++) {
                char curr = dictionary[i].charAt(j);
                map.put(curr, new int[]{i, j});
            }
        }
        char p = 'a';
        boolean hasZ;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int[] prev = map.get(p);
            int[] curr = map.get(c);
            // 上一步在'z'
            hasZ = (p == 'z');
            String fragment = packageStr(prev, curr, hasZ);
            sb.append(fragment);
            sb.append("!");
            p = c;
        }
        return sb.toString();
    }

    public String packageStr(int[] prev, int[] curr, boolean hasZ) {

        StringBuilder sb = new StringBuilder();
        if (Arrays.equals(prev, curr)) {
            return "";
        }
        if (hasZ) {
            int d1 = curr[0] - prev[0];
            for (int i = 0; i < Math.abs(d1); i++) {
                if (d1 > 0) {
                    sb.append('D');
                } else if (d1 < 0) {
                    sb.append('U');
                }
            }
        }
        // 因为'z'的存在，优先上下走
        int d2 = curr[1] - prev[1];
        for (int i = 0; i < Math.abs(d2); i++) {
            if (d2 > 0) {
                sb.append('R');
            } else if (d2 < 0) {
                sb.append('L');
            }
        }
        if (!hasZ) {
            int d1 = curr[0] - prev[0];
            for (int i = 0; i < Math.abs(d1); i++) {
                if (d1 > 0) {
                    sb.append('D');
                } else if (d1 < 0) {
                    sb.append('U');
                }
            }
        }
        return sb.toString();
    }
}
