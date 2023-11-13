/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/22 09:13 22
 * @since 1.0
 **/
public class No1791 {

    /**
     * 找出星型图的中心节点
     *
     * @param edges
     * @return
     */
    public int findCenter(int[][] edges) {
        int[] bucket = new int[edges.length + 1];
        int ans = 0;
        for (int[] edge : edges) {
            bucket[edge[0] - 1]++;
            bucket[edge[1] - 1]++;
            ans = bucket[edge[0] - 1] == bucket.length - 1 ? edge[0] : ans;
            ans = bucket[edge[1] - 1] == bucket.length - 1 ? edge[1] : ans;
        }
        return ans;
    }

}
