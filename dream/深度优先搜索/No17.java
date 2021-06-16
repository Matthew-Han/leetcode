package 深度优先搜索;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LetterCombinationsOfaPhoneNumber
 * @Description #17 电话号码的字母组合
 * @Author MatthewHan
 * @Date 2020/8/26 09:45
 * @Version 1.0
 **/
public class No17 {


    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 33.06% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 8.13% 的用户
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        if ("".equals(digits) || null == digits) {
            return new ArrayList<>();
        }
        Map<Character, char[]> map = new HashMap<>(16);
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> res = new ArrayList<>();
        dfs(map, res, digits, 0, "");
        return res;
    }

    public static void dfs(Map<Character, char[]> map, List<String> res, String digits, int start, String tmp) {
        if (start == digits.length()) {
            res.add(tmp);
            return;
        }
        char index = digits.charAt(start);
        String next;
        char[] values = map.get(index);
        for (char value : values) {
            next = tmp + value;
            dfs(map, res, digits, start + 1, next);
        }
    }

    public static void main(String[] args) {
        letterCombinations("21334");
    }
}
