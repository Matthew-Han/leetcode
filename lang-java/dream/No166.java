import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/9 09:00
 * @since 1.0
 **/
public class No166 {

    String ans;
    Map<Long, Integer> vis;
    int flag;
    int idx;

    /**
     * 分数到小数
     *
     * @param a
     * @param b
     * @return
     */
    public String fractionToDecimal(int a, int b) {
        ans = "";
        vis = new HashMap<>();
        flag = -1;
        idx = 0;
        long numerator = a;
        long denominator = b;
        if (numerator % denominator == 0) {
            return "" + numerator / denominator;
        }
        if (numerator < 0 && denominator < 0 || numerator > 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        if (numerator < 0 && numerator / denominator == 0) {
            ans += "-";
        }

        ans += numerator / denominator + ".";
        dfs(Math.abs(numerator % denominator) * 10L, denominator);
        if (flag >= 0) {
            //System.out.println("idx = " + idx);
            StringBuilder sb = new StringBuilder(ans);
            sb.insert(sb.length() - flag, "(");
            return sb + ")";
        }
        return ans;

    }


    public void dfs(long p, long q) {
        vis.put(p, idx++);
        if (p < q) {
            ans += 0;
            dfs(p * 10, q);
        } else {
            ans += p / q;
            if (p % q == 0) {
                return;
            }
            if (vis.containsKey(p % q * 10)) {
                flag = idx - vis.get(p % q * 10);
                return;
            }
            dfs(p % q * 10, q);
        }
    }
}
