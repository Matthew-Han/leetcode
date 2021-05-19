import com.sun.org.apache.bcel.internal.generic.NEW;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PositionsOfLargeGroups
 * @Description #830 较大分组的位置
 * @Author MatthewHan
 * @Date 2020/6/19 11:26
 * @Version 1.0
 **/
public class No830 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param s
     * @return
     */
    public static List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> list = new ArrayList<>();
        int left = 0;
        int point = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            System.out.println("point = " + point);
            if (point != s.charAt(i)) {
                if (i - left >= 3) {
                    List<Integer> temp = new ArrayList<>(2);
                    temp.add(left);
                    temp.add(i - 1);
                    list.add(temp);
                }
                left = i;
                point = s.charAt(left);
            }
            if (i == s.length() - 1) {
                if (i - left >= 2) {
                    List<Integer> temp = new ArrayList<>(2);
                    temp.add(left);
                    temp.add(i);
                    list.add(temp);
                }
            }

        }
        return list;

    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}
