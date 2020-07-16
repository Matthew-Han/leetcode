package lcp;

import java.util.*;

/**
 * @ClassName lcp.QiWangGeShuTongJi
 * @Description #LCP 11 期望个数统计
 * @Author MatthewHan
 * @Date 2020/7/16 14:22
 * @Version 1.0
 **/
public class QiWangGeShuTongJi {




    /**
     * 执行用时： 28 ms , 在所有 Java 提交中击败了 44.86% 的用户
     * 内存消耗： 50 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param scores
     * @return
     */
    public int expectNumber(int[] scores) {
        Set<Integer> set = new HashSet<>();
        for (int score : scores) {
            set.add(score);
        }
        return set.size();
    }

    public static void main(String[] args) {

    }
}
