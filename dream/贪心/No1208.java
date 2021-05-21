package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName CheckIfaStringCanBreakAnotherString
 * @Description #1433 检查一个字符串是否可以打破另一个字符串
 * @Author MatthewHan
 * @Date 2020/8/31 09:01
 * @Version 1.0
 **/
public class No1208 {

    /**
     * 贪心遇上桶排更配哦！昨晚又通宵了，懒得优化了。
     * btw 今天周一
     * 执行用时： 226 ms , 在所有 Java 提交中击败了 5.16% 的用户
     * 内存消耗： 42.4 MB , 在所有 Java 提交中击败了 5.51% 的用户
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Character[] characters1 = new Character[chars1.length];
        Character[] characters2 = new Character[chars2.length];
        for (int i = 0; i < chars1.length; i++) {
            characters1[i] = chars1[i];
        }
        for (int i = 0; i < chars2.length; i++) {
            characters2[i] = chars2[i];
        }
        Arrays.sort(characters1, (Comparator<Character>) Integer::compare);
        Arrays.sort(characters2, (Comparator<Character>) Integer::compare);
        int z = 0;
        int f = 0;
        for (int i = 0; i < characters1.length; i++) {
            if (characters1[i] - characters2[i] < 0) {
                f++;
            } else if (characters1[i] - characters2[i] > 0) {
                z++;
            }
        }
        return !(z > 0 && f > 0);
    }

    public static void main(String[] args) {
        checkIfCanBreak("abc", "ayx");
    }
}

