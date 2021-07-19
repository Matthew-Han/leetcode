import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/19 09:16
 * @since 1.0
 **/
public class M1002 {

    /**
     * 变位词组
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Set<String> set = new HashSet<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            set.add(new String(arr));
        }
        boolean[] vis = new boolean[strs.length];
        List<List<String>> ans = new ArrayList<>();
        for (String title : set) {
            List<String> sub = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                if (vis[i]) {
                    continue;
                }
                if (check(strs[i], title.toCharArray())) {
                    sub.add(strs[i]);
                    vis[i] = true;
                }
            }
            ans.add(sub);
        }
        return ans;
    }

    public boolean check(String src, char[] target) {
        if (src.length() != target.length) {
            return false;
        }
        char[] srcArr = src.toCharArray();
        Arrays.sort(srcArr);
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
