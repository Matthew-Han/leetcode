import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PalindromePermutation
 * @Description 面试题 01.04. 回文排列
 * @Author MatthewHan
 * @Date 2020/7/23 15:08
 * @Version 1.0
 **/
public class M0104 {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 71.52% 的用户
     * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int oddCount = 0;
        for (Integer value : map.values()) {
            if ((value & 1) != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }

}
