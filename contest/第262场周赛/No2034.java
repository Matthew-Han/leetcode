package 第262场周赛;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/11 10:26
 * @since 1.0
 **/
public class No2034 {
    TreeMap<Integer, Integer> map;
    TreeMap<Integer, Set<Integer>> data;

    /**
     * 股票价格波动
     */
    public No2034() {
        map = new TreeMap<>();
        data = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int oldPrice = map.get(timestamp);
            Set<Integer> priceSet = data.get(oldPrice);
            if (null != priceSet) {
                priceSet.remove(timestamp);
                if (priceSet.isEmpty()) {
                    data.remove(oldPrice);
                }
            }
        }
        if (data.containsKey(price)) {
            data.get(price).add(timestamp);
        } else {
            data.put(price, new HashSet<Integer>() {{
                add(timestamp);
            }});
        }
        map.put(timestamp, price);
    }

    public int current() {
        return map.lastEntry().getValue();
    }

    public int maximum() {
        return data.lastKey();
    }

    public int minimum() {
        return data.firstKey();
    }
}