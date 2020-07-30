import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName KidsWithTheGreatestNumberOfCandies
 * @Description #1431 拥有最多糖果的孩子
 * @Author MatthewHan
 * @Date 2020/7/14 16:05
 * @Version 1.0
 **/
public class KidsWithTheGreatestNumberOfCandies {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.92% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>(candies.length);
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int candy : candies) {
            list.add(candy + extraCandies >= max);
        }
        return list;
    }
}
