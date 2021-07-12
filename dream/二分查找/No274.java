package 二分查找;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/12 09:22
 * @since 1.0
 **/
public class No274 {

    /**
     * H 指数
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 1;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= ans) {
                ans++;
            } else {
                return ans - 1;
            }
        }
        return ans - 1;
    }
}
