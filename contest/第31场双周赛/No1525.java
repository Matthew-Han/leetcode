package 第31场双周赛;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NumberOfGoodWaysToSplitAstring
 * @Description #1525 字符串的好分割数目
 * @Author MatthewHan
 * @Date 2020/7/25 20:25
 * @Version 1.0
 **/
public class No1525 {


    /**
     * #3
     * Medium
     * <p>
     * 执行用时： 1289 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static int numSplits(String s) {
        int i = 0;
        int j = i + 1;
        int count = 0;
        StringBuilder left = new StringBuilder(s.substring(0, j));
        int leftNum = count(left.toString());
        StringBuilder right = new StringBuilder(s.substring(j));
        int rightNum = count(right.toString());
        if (leftNum == rightNum) {
            count++;
        }
        int index = 0;
        while (j < s.length()) {

            if (!left.toString().contains(String.valueOf(s.charAt(j)))) {
                left.append(s.charAt(j));
                leftNum++;
            }
            right.deleteCharAt(index);
            if (!right.toString().contains(String.valueOf(s.charAt(j)))) {
                rightNum--;
            }
            if (leftNum == rightNum) {
                count++;
            }
            j++;
        }
        return count;
    }

    public static int count(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));

        }
        return set.size();
    }

    public static void main(String[] args) {

    }
}
