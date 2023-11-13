package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CountNumberOfTeams
 * @Description #1395 统计作战单位数
 * @Author MatthewHan
 * @Date 2020/9/4 15:01
 * @Version 1.0
 **/
public class No1395 {
    int count;

    /**
     * 执行用时： 217 ms , 在所有 Java 提交中击败了 5.01% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 5.18% 的用户
     *
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        for (int i = 0; i < rating.length - 2; i++) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list1.add(rating[i]);
            list2.add(rating[i]);
            dfs1(rating, i, list1);
            dfs2(rating, i, list2);
        }
        return count;
    }

    public void dfs1(int[] rating, int index, List<Integer> list) {
        System.out.println("list = " + list);
        if (list.size() == 3) {
            count++;
            return;
        }
        for (int i = index; i < rating.length; i++) {
            if (rating[i] < list.get(list.size() - 1)) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(rating[i]);
                dfs1(rating, i + 1, newList);
            }
        }
    }

    public void dfs2(int[] rating, int index, List<Integer> list) {
        if (list.size() == 3) {
            count++;
            return;
        }
        for (int i = index; i < rating.length; i++) {
            if (rating[i] > list.get(list.size() - 1)) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(rating[i]);
                dfs2(rating, i + 1, newList);
            }
        }
    }
}
