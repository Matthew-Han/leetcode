package 第238场周赛;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/25 15:30
 * @since 1.0.0
 **/
public class No1837 {

    /**
     * #1837 K 进制表示下的各位数字总和
     *
     * @param n
     * @param k
     * @return
     */
    public int sumBase(int n, int k) {
        int ans = 0;
        String tmp = Integer.toString(n, k);
        for (int i = 0; i < tmp.length(); i++) {
            ans += tmp.charAt(i) - '0';
        }
        return ans;
    }

}
