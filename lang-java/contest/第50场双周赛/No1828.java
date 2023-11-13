package 第50场双周赛;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/17 22:27
 * @since 1.0.0
 **/
public class No1828 {


    /**
     * #1828 统计一个圆中点的数目
     *
     * @param points
     * @param queries
     * @return
     */
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int count = 0;
            for (int[] point : points) {
                double x = Math.pow(point[0] - query[0], 2) + Math.pow(point[1] - query[1], 2);
                double src = Math.sqrt(x);
                if (src <= query[2]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }


}
