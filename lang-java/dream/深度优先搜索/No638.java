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
        int cnt = 0;
        for (int i = 0; i < price.size(); i++) {
            min += price.get(i) * needs.get(i);
            cnt += needs.get(i);
        }

        dfs(special, needs, cnt, 0);
        return min;

    }

    public void dfs(List<List<Integer>> special, List<Integer> needs, int cnt, int spend) {
        if (cnt <= 0 || spend >= min) {
            min = Math.min(min, spend);
            return;
        }
        for (List<Integer> sub : special) {
            boolean flag = false;
            int diff = 0;
            StringBuilder k = new StringBuilder();
            for (int i = 0; i < sub.size() - 1; i++) {
                diff += sub.get(i);
                if (needs.get(i) - sub.get(i) < 0) {
                    flag = true;
                    break;
                }
                k.append(needs.get(i) - sub.get(i));
                k.append("-");
            }
            if (flag) {
                continue;
            }
            int nxt = spend + sub.get(sub.size() - 1);

            if (!mem.containsKey(k.toString())) {
                mem.put(k.toString(), nxt);
                // 回溯了
                copy(sub, needs);
                dfs(special, needs, cnt - diff, nxt);
                recover(sub, needs);
            } else {
                if (mem.get(k.toString()) > nxt) {
                    mem.put(k.toString(), nxt);
                    copy(sub, needs);
                    dfs(special, needs, cnt - diff, nxt);
                    recover(sub, needs);
                }
            }
        }
    }


    public void copy(List<Integer> src, List<Integer> dest) {
        for (int i = 0; i < dest.size(); i++) {
            dest.set(i, dest.get(i) - src.get(i));
        }
    }

    private void recover(List<Integer> src, List<Integer> dest) {
        for (int i = 0; i < dest.size(); i++) {
            dest.set(i, dest.get(i) + src.get(i));
        }
    }

    public static void main(String[] args) {
        No638 demo = new No638();
        List<List<Integer>> sp = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>(Arrays.asList(3, 0, 5)));
            add(new ArrayList<Integer>(Arrays.asList(1, 2, 10)));
        }};
        System.out.println(demo.shoppingOffers(new ArrayList<>(Arrays.asList(2, 5)), sp, new ArrayList<>(Arrays.asList(3, 2))));
    }
}
