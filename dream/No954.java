import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/1 12:22 01
 * @since 1.0
 **/
public class No954 {


    /**
     * 二倍数对数组
     * <p>
     * 升序排序遍历：
     * <p>
     * 当前元素如果 >= 0，则寻找满足 2 倍与当前元素的值；
     * <p>
     * 如果是 < 0，则寻找当前元素 / 2 的值，注意如果是负数 / 2 需要判断当前元素是否是偶数；
     * <p>
     * 利用 map 的 val 判断是否需要跳过当前循环。
     *
     * @param arr
     * @return
     */
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Arrays.sort(arr);
        for (int curr : arr) {
            if (map.get(curr) <= 0) {
                continue;
            }
            int nxt;
            if (curr == 0) {
                nxt = 0;
            } else if (curr < 0) {
                if (curr % 2 != 0) {
                    return false;
                }
                nxt = curr / 2;
            } else {
                nxt = curr * 2;
            }
            if (!map.containsKey(nxt) || map.get(nxt) <= 0) {
                return false;
            }
            map.put(curr, map.get(curr) - 1);
            map.put(nxt, map.get(nxt) - 1);
        }
        return true;

    }
}
