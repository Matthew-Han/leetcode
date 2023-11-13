package 二分查找;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/11 00:45
 * @since 1.0
 **/
public class No981 {

    Map<String, TreeMap<Integer, String>> data;

    /**
     * 基于时间的键值存储
     */
    public No981() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> v;
        if (!data.containsKey(key)) {
            v = new TreeMap<>();
        } else {
            v = data.get(key);
        }
        v.put(timestamp, value);
        data.put(key, v);

    }

    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) {
            return "";
        }
        Map.Entry<Integer, String> res = data.get(key).floorEntry(timestamp);
        return res == null ? "" : res.getValue();
    }
}
