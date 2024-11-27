import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RomanToInteger
 * @Description #13 罗马数字转整数
 * @Author MatthewHan
 * @Date 2020/7/16 18:26
 * @Version 1.0
 **/
public class No13 {

    /**
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 30.30% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 5.56% 的用户
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int sum = 0;

        for (int i = 0; i < s.length(); ++i) {
            int left = map.get(String.valueOf(s.charAt(i)));
            int right = i + 1 < s.length() ? map.get(String.valueOf(s.charAt(i + 1))) : 0;
            // 小的数字位于大的数字左边
            if (left < right) {
                sum -= left;
            } else {
                sum += left;
            }
        }
        return sum;

    }

}
