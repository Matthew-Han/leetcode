/**
 * @author Matthew Han
 * @date 2021/5/6 12:38
 * @description
 * @since 1.0.0
 **/
public class DecodeXoRedArray {

    /**
     * #1720 解码异或后的数组
     *
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 1; i < encoded.length + 1; i++) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
        }
        return ans;
    }
}
