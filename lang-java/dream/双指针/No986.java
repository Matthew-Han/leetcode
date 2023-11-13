package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName IntervalListIntersections
 * @Description #986 区间列表的交集
 * @Author MatthewHan
 * @Date 2020/8/9 02:48
 * @Version 1.0
 **/
public class No986 {

    /**
     * wdnmd，写死老子了。
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 51.40% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 83.19% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> res = new ArrayList<>();
        int len1 = a.length;
        int len2 = b.length;
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            // 当前两个完全错开
            if (a[i][1] < b[j][0]) {
                i++;
            } else if (a[i][0] > b[j][1]) {
                j++;
            } else {
                // 重合边
                if (a[i][1] == b[j][0]) {
                    res.add(new int[]{a[i][1], a[i][1]});
                    i++;
                    continue;
                }
                if (a[i][0] == b[j][1]) {
                    res.add(new int[]{a[i][0], a[i][0]});
                    j++;
                    continue;
                }

                // 情况 1：b 比 a 长
                if (a[i][1] < b[j][1]) {
                    if (a[i][0] > b[j][0]) {
                        res.add(new int[]{a[i][0], a[i][1]});
                    } else {
                        res.add(new int[]{b[j][0], a[i][1]});
                    }
                    i++;
                    continue;
                }
                // 情况 2
                if (a[i][1] > b[j][1]) {
                    if (a[i][0] > b[j][0]) {
                        res.add(new int[]{a[i][0], b[j][1]});
                    } else {
                        res.add(new int[]{b[j][0], b[j][1]});
                    }
                    j++;
                    continue;
                }
                // 情况 3
                if (a[i][1] == b[j][1]) {
                    if (a[i][0] > b[j][0]) {
                        res.add(new int[]{a[i][0], a[i][1]});
                    } else {
                        res.add(new int[]{b[j][0], a[i][1]});
                    }
                    i++;
                    j++;
                }
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(intervalIntersection(new int[][]{{1, 7}}, new int[][]{{3, 10}})));
    }
}
