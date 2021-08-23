package 第255场周赛;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/23 10:44
 * @since 1.0
 **/
public class No1980 {

    boolean flag;
    String ans;

    /**
     * 找出不同的二进制字符串
     *
     * @param nums
     * @return
     */
    public String findDifferentBinaryString(String[] nums) {
        flag = false;
        ans = "";
        Set<String> set = new HashSet<>();
        Collections.addAll(set, nums);
        dfs(set, nums.length, "");
        return ans;
    }

    public void dfs(Set<String> set, int n, String curr) {
        if (flag) {
            return;
        }
        if (curr.length() >= n) {
            if (!set.contains(curr)) {
                ans = curr;
                flag = true;
            }
            return;
        }
        dfs(set, n, curr + "0");
        dfs(set, n, curr + "1");
    }
}
