/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/1 10:50
 * @since 1.0
 **/
public class No165 {

    /**
     * 比较版本号
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] char1 = version1.split("\\.");
        String[] char2 = version2.split("\\.");
        int k = Math.max(char1.length, char2.length);
        for (int i = 0; i < k; i++) {
            int v1 = i >= char1.length ? 0 : Integer.parseInt(char1[i]);
            int v2 = i >= char2.length ? 0 : Integer.parseInt(char2[i]);

            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}
