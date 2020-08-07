package 双指针;

import java.util.*;

/**
 * @ClassName PartitionLabels
 * @Description #763 划分字母区间
 * @Author MatthewHan
 * @Date 2020/8/7 18:02
 * @Version 1.0
 **/
public class PartitionLabels {

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 97.46% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 88.46% 的用户
     *
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        // 存最右端就可以了
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i) - 'a');
            map[s.charAt(i) - 'a'] = i;
        }

        System.out.println("map = " + Arrays.toString(map));
        int i = 0;
        while (i < s.length()) {
            int start = s.indexOf(s.charAt(i));
            int end = s.lastIndexOf(s.charAt(i));

            int maxIndex = check(map, s, start, end + 1);

            res.add(maxIndex + 1 - start);
            i = maxIndex + 1;
        }
        return res;

    }

    /**
     * @param map
     * @param s
     * @param start
     * @param end
     * @return -1说明sub里的字符不存在后面的子串，不然返回后半子串的下标
     */
    public static int check(int[] map, String s, int start, int end) {
        int maxIndex = 0;
        boolean flag = true;
        while (flag) {
            for (int i = start; i < end; i++) {
                maxIndex = Math.max(maxIndex, map[s.charAt(i) - 'a']);
            }
            if (end != maxIndex) {
                end = maxIndex;
            } else {
                flag = false;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("qiejxqfnqceocmy"));
    }
}
