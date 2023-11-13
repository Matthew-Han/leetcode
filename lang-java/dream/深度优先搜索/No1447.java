package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/9/27 16:02
 **/
public class No1447 {


    /**
     * #1447 最简分数
     * 执行用时： 39 ms , 在所有 Java 提交中击败了 26.30% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 43.98% 的用户
     *
     * @param n
     * @return
     */
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                if (check(i, j)) {
                    res.add(i + "/" + j);
                }
            }
        }
        return res;
    }

    public boolean check(int i, int j) {
        for (int k = i; k > 1; k--) {
            if (i % k == 0 && j % k == 0) {
                return false;
            }
        }
        return true;
    }

}
