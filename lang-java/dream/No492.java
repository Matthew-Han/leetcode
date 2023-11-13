import java.util.*;

/**
 * @ClassName ConstructTheRectangle
 * @Description #492 构造矩形
 * @Author MatthewHan
 * @Date 2020/5/18 11:28
 * @Version 1.0
 **/
public class No492 {

    /**
     * 在 double 类型的平方根转换成int类型，在该处找会比较快一点。
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.8 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param area
     * @return
     */
    public static int[] constructRectanglePro(int area) {
        int sqrt = (int) Math.sqrt(area);
        while (sqrt > 0) {
            if (area % sqrt == 0) {
                return new int[]{Math.max(sqrt, area / sqrt), Math.min(sqrt, area / sqrt)};
            }
            sqrt--;
        }
        return new int[0];
    }

    /**
     * 执行用时 : 264 ms , 在所有 Java 提交中击败了 8.32% 的用户
     * 内存消耗 : 36.9 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param area
     * @return
     */
    public static int[] constructRectangle(int area) {
        if (area == 0) {
            return new int[]{};
        }
        int start = 1;
        int end;
        int diff;
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (start == 1 || start == 2 || start <= area / 3) {
            if (area % start == 0) {
                end = area / start;
                diff = Math.max(start, end) - Math.min(start, end);
                if (min > diff) {
                    List<Integer> rectangle = new ArrayList<>(2);
                    rectangle.add(start);
                    rectangle.add(end);
                    map.clear();
                    map.put(diff, rectangle);
                    min = diff;
                }
            }
            start++;
        }
        System.out.println(map);
        int[] result = new int[2];
        result[0] = map.get(min).get(1);
        result[1] = map.get(min).get(0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectanglePro(0)));
    }


}
