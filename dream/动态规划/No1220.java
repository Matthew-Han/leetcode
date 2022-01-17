package 动态规划;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/17 09:34
 * @since 1.0
 **/
public class No1220 {

    /**
     * 统计元音字母序列的数目
     *
     * @param n
     * @return
     */
    public int countVowelPermutation(int n) {
        int cnt = 0;
        int[] fuck = new int[5];
        int[] nxt = new int[5];
        int mod = (int) (1e9 + 7);
        Arrays.fill(fuck, 1);
        for (int i = 1; i < n; i++) {
            // a
            nxt[1] += fuck[0];
            nxt[1] %= mod;
            // e
            nxt[0] += fuck[1];
            nxt[0] %= mod;
            nxt[2] += fuck[1];
            nxt[2] %= mod;
            // i
            nxt[0] += fuck[2];
            nxt[0] %= mod;
            nxt[1] += fuck[2];
            nxt[1] %= mod;
            nxt[3] += fuck[2];
            nxt[3] %= mod;
            nxt[4] += fuck[2];
            nxt[4] %= mod;
            // o
            nxt[2] += fuck[3];
            nxt[2] %= mod;
            nxt[4] += fuck[3];
            nxt[4] %= mod;
            // u
            nxt[0] += fuck[4];
            nxt[0] %= mod;
            fuck = nxt;

        }
        for (int i = 0; i < 5; i++) {
            cnt += fuck[i];
            cnt %= mod;
        }
        return cnt;
    }


}
