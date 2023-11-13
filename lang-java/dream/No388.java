/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/20 11:12 20
 * @since 1.0
 **/
public class No388 {


    /**
     * 文件的最长绝对路径
     *
     * @param input
     * @return
     */
    public int lengthLongestPath(String input) {
        int ans = 0;
        input = input.replaceAll("\\t", "/");
        String[] split = input.split("\\n");
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].indexOf('.') == -1) {
                continue;
            }
            int cnt = count(split[i]);
            int size = split[i].length() - cnt;
            for (int j = i - 1; j >= 0; j--) {
                int subSize = count(split[j]);
                if (split[j].indexOf('.') == -1 && subSize == cnt - 1) {
                    size += split[j].length() - subSize + 1;
                    cnt--;
                }
            }
            ans = Math.max(ans, size);
        }
        return ans;
    }

    private int count(String sub) {
        int ans = 0;
        for (int i = 0; i < sub.length(); i++) {
            if (sub.charAt(i) == '/') {
                ans++;
            } else {
                break;
            }
        }
        return ans;

    }

}
