import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @since 2023/9/27 09:46:14
 **/
public class No1333 {


    /**
     * 餐厅过滤器
     *
     * @param restaurants
     * @param veganFriendly
     * @param maxPrice
     * @param maxDistance
     * @return
     */
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> tmp = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if ((veganFriendly != 1 || restaurant[2] == veganFriendly) && maxDistance >= restaurant[4] && maxPrice >= restaurant[3]) {
                tmp.add(restaurant);
            }
        }
        tmp.sort((o1, o2) -> o2[1] == o1[1] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o2[1], o1[1]));
        return tmp.stream().map(x -> x[0]).collect(Collectors.toList());
    }
}
