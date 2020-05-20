import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName DistributeCandies
 * @Description #575 分糖果
 * @Author MatthewHan
 * @Date 2020/5/20 17:30
 * @Version 1.0
 **/
public class DistributeCandies {

    /**
     * 执行用时 : 42 ms , 在所有 Java 提交中击败了 57.07% 的用户
     * 内存消耗 : 41.8 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param candies
     * @return
     */
    public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    public static void main(String[] args) {
        distributeCandies(new int[]{1, 1, 1, 11, 1, 1, 2, 3});
    }
}
