package 贪心;

import java.util.Random;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/14 02:31
 **/
public class CouplesHoldingHands {

    /**
     * #765 情侣牵手
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.9 MB , 在所有 Java 提交中击败了 56.54% 的用户
     *
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        // 动态缓存装载
        int[] map = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            map[row[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i < row.length - 1; i += 2) {
            // 偶数
            if ((row[i] & 1) == 0) {
                int tmp = row[i] + 1;
                // 配对
                if (row[i + 1] != tmp) {
                    int index = map[tmp];
                    int index2 = map[row[i + 1]];
                    ans++;
                    row[i + 1] ^= row[index];
                    row[index] ^= row[i + 1];
                    row[i + 1] ^= row[index];
                    // 缓存刷新
                    map[row[index]] = index;
                    map[row[i + 1]] = index2;
                }
            } else {
                int tmp = row[i] - 1;
                if (row[i + 1] != tmp) {
                    int index = map[tmp];
                    int index2 = map[row[i + 1]];
                    ans++;
                    row[i + 1] ^= row[index];
                    row[index] ^= row[i + 1];
                    row[i + 1] ^= row[index];
                    // 缓存刷新
                    map[row[index]] = index;
                    map[row[i + 1]] = index2;
                }
            }
        }
        return ans;
    }

}
