package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/29 16:08
 **/
public class GrayCode {

    List<Integer> res = new ArrayList<>();

    /**
     * #89 格雷编码
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        boolean[] vis = new boolean[1 << n];
        int[] start = new int[n];
        vis[0] = true;
        res.add(0);
        dfs(start, vis);
        return res;
    }

    public void dfs(int[] arr, boolean[] vis) {
        if (res.size() == (1 << arr.length)) {
            return;
        }
        int[] tmp = new int[arr.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = tmp[i] == 1 ? 0 : 1;
            if (!check(tmp, vis)) {
                int next = get(tmp);
                vis[next] = true;
                res.add(next);
                break;
            } else {
                tmp[i] = tmp[i] == 1 ? 0 : 1;
            }
        }
        dfs(tmp, vis);
    }

    public boolean check(int[] tmp, boolean[] vis) {
        StringBuilder sb = new StringBuilder();
        for (int n : tmp) {
            sb.append(n);
        }
        int r = Integer.valueOf(sb.toString(), 2);
        return vis[r];

    }

    public int get(int[] tmp) {
        StringBuilder sb = new StringBuilder();
        for (int n : tmp) {
            sb.append(n);
        }
        return Integer.valueOf(sb.toString(), 2);
    }
}
