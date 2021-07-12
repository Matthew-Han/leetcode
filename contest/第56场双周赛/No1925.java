package 第56场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/10 22:16
 * @since 1.0
 **/
public class No1925 {


    /**
     * 统计平方和三元组的数目
     *
     * @param n
     * @return
     */
    public int countTriples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                double sum = Math.pow(i, 2) + Math.pow(j, 2);
                if (Math.sqrt(sum) <= n && Math.sqrt(sum) == (int) Math.sqrt(sum)) {
                    ans++;
                }
            }
        }
        return ans;
    }

}



