package 第67场双周赛;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/12/13 15:30
 * @since 1.0
 **/
public class No2100 {

    public List<Integer> date20220307(int[] security, int time) {
        int[] l = new int[security.length];
        int[] r = new int[security.length];
        for (int i = 1; i < security.length; i++) {
            if (security[i - 1] >= security[i]) {
                l[i] += l[i - 1] + 1;
            }
        }
        for (int i = security.length - 2; i >= 0; i--) {
            if (security[i + 1] >= security[i]) {
                r[i] += r[i + 1] + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < security.length; i++) {
            if (l[i] >= time && r[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
    }


    /**
     * 适合打劫银行的日子
     *
     * @param security
     * @param time
     * @return
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        if (time == 0) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < security.length; i++) {
                ans.add(i);
            }
            return ans;
        }
        if (time >= security.length) {
            return new ArrayList<>();
        }
        // 0 simple 1 complex
        Map<String, Boolean> cache = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int[] first = fuck(security, 0, time);
        cache.put(0 + "-" + time, first[0] + first[1] == time || first[0] + first[2] == time);
        for (int i = 1; i < security.length - time; i++) {
            if (security[i - 1] == security[i]) {
                first[0]--;
            } else if (security[i - 1] < security[i]) {
                first[1]--;
            } else {
                first[2]--;
            }

            if (security[i - 1 + time] == security[i + time]) {
                first[0]++;
            } else if (security[i - 1 + time] < security[i + time]) {
                first[1]++;
            } else {
                first[2]++;
            }

            cache.put(i + "-" + (i + time), first[0] + first[1] == time || first[0] + first[2] == time);
        }
        for (int i = time; i < security.length - time; i++) {
            String k = i - time + "-" + i;

            if (!cache.get(k)) {
                continue;
            }
            // left
            boolean flag = security[i - time] >= security[i];
            k = i + "-" + (i + time);
            if (!cache.get(k)) {
                continue;
            }
            if (flag && security[i] <= security[i + time]) {
                ans.add(i);
            }

        }

        return ans;
    }

    // 0 递增， 1 递减
    public int[] fuck(int[] nums, int s, int e) {
        int[] counter = new int[3];
        for (int i = s; i < e; i++) {
            if (nums[i] == nums[i + 1]) {
                counter[0]++;
            } else if (nums[i] < nums[i + 1]) {
                counter[1]++;
            } else {
                counter[2]++;
            }
        }
        return counter;
    }
}
