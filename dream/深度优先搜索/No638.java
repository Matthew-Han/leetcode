package 深度优先搜索;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/25 14:56
 * @since 1.0
 **/
public class No638 {

    Map<String, Integer> mem;
    int min;

    /**
     * 大礼包
     *
     * @param price
     * @param special
     * @param needs
     * @return
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.min = 0;
        this.mem = new HashMap<>();
        for (int i = 0; i < price.size(); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < price.size(); j++) {
                sub.add(i == j ? 1 : 0);
            }
            sub.add(price.get(i));
            special.add(sub);
        }
        for (int i = 0; i < price.size(); i++) {
            min += price.get(i) * needs.get(i);
        }

        int[] spends = new int[price.size()];
        dfs(special, needs, spends, 0);
        return min;

    }

    public void dfs(List<List<Integer>> special, List<Integer> needs, int[] spends, int spend) {
        if (check(needs, spends) || spend >= min) {
            min = Math.min(min, spend);
            return;
        }
        for (List<Integer> sub : special) {
            boolean flag = false;
            StringBuilder k = new StringBuilder();
            for (int i = 0; i < sub.size() - 1; i++) {
                if (spends[i] + sub.get(i) > needs.get(i)) {
                    flag = true;
                    break;
                }
                k.append(spends[i] + sub.get(i));
                k.append("-");
            }
            if (flag) {
                continue;
            }
            int nxt = spend + sub.get(sub.size() - 1);

            if (!mem.containsKey(k.toString())) {
                mem.put(k.toString(), nxt);
                // 回溯了
                copy(sub, spends);
                dfs(special, needs, spends, nxt);
                reCopy(sub, spends);
            } else {
                if (mem.get(k.toString()) > nxt) {
                    mem.put(k.toString(), nxt);
                    copy(sub, spends);
                    dfs(special, needs, spends, nxt);
                    reCopy(sub, spends);
                }
            }
        }
    }


    public boolean check(List<Integer> needs, int[] spends) {
        for (int i = 0; i < needs.size(); i++) {
            if (!Objects.equals(needs.get(i), spends[i])) {
                return false;
            }
        }
        return true;
    }

    public void copy(List<Integer> src, int[] dest) {
        for (int i = 0; i < dest.length; i++) {
            dest[i] = src.get(i) + dest[i];
        }
    }

    private void reCopy(List<Integer> src, int[] dest) {
        for (int i = 0; i < dest.length; i++) {
            dest[i] = dest[i] - src.get(i);
        }
    }
}
