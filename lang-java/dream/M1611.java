/**
 * @ClassName DivingBoard
 * @Description 面试题 16.11. 跳水板
 * @Author MatthewHan
 * @Date 2020/7/29 09:40
 * @Version 1.0
 **/
public class M1611 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 92.46% 的用户
     * 内存消耗： 47.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {

        if (k == 0) {
            return new int[]{};
        }
        // 特殊情况 shorter == longer
        if (longer - shorter == 0) {
            return new int[]{k};
        }

        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = longer * i + shorter * (k - i);
        }
        return res;

    }

}
