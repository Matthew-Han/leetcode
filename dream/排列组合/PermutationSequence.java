package 排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PermutationSequence
 * @Description #60 第k个排列
 * @Author MatthewHan
 * @Date 2020/9/5 03:17
 * @Version 1.0
 **/
public class PermutationSequence {

    boolean flag;
    String ans;

    /**
     * 执行用时： 1363 ms , 在所有 Java 提交中击败了 6.17% 的用户
     * 内存消耗： 77.7 MB , 在所有 Java 提交中击败了 6.93% 的用户
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n];
            visited[i - 1] = true;
            dfs(k, n, visited, String.valueOf(i), res);
            if (flag) {
                return ans;
            }
        }
        return res.get(res.size() - 1);

    }

    public void dfs(int k, int n, boolean[] visited, String curr, List<String> res) {
        if (res.size() == k) {
            flag = true;
            ans = res.get(res.size() - 1);
            return;
        }
        if (curr.length() == n) {
            res.add(curr);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i - 1]) {
                // 数组和新字符串要用新的对象
                boolean[] newVisited = new boolean[n];
                System.arraycopy(visited, 0, newVisited, 0, n);
                newVisited[i - 1] = true;
                String next = curr + i;
                dfs(k, n, newVisited, next, res);
            }
        }


    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(2, 2));
    }


}
