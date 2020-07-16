import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RomanToInteger
 * @Description #13 罗马数字转整数
 * @Author MatthewHan
 * @Date 2020/7/16 18:26
 * @Version 1.0
 **/
public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int sum = 0;

        for (int i = s.length(); i > 0; i--) {
            if (i > 1 && map.get(s.substring(i - 2, i)) != null) {
                System.out.println("1 = " + s.substring(i - 2, i));
                sum += map.get(s.substring(i - 2, i));
                i--;
            } else {
                System.out.println("2 = " + s.charAt(i - 1));
                sum += map.get(String.valueOf(s.charAt(i - 1)));
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("CXIIVCLCDMCX"));
    }

}
