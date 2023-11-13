package 二分查找;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/12 09:22
 * @since 1.0
 **/
public class No275 {

    /**
     * H 指数 II
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        int l = 0;
        int r = len;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] >= len - mid) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return len - l;
    }
}
