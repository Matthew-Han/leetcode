package 设计题;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/18 15:59 18
 * @since 1.0
 **/
public class No432 {

    Map<String, Integer> map = new HashMap<>();

    TreeMap<Integer, Set<String>> maxMap = new TreeMap<>(((o1, o2) -> Integer.compare(o2, o1)));

    TreeMap<Integer, Set<String>> minMap = new TreeMap<>();


    /**
     * 全 O(1) 的数据结构
     */
    public No432() {

    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            int size = map.get(key);
            Set<String> maxV = maxMap.get(size);
            Set<String> minV = minMap.get(size);
            maxV.remove(key);
            if (maxV.isEmpty()) {
                maxMap.remove(size);
            } else {
                maxMap.put(size, maxV);
            }
            minV.remove(key);
            if (minV.isEmpty()) {
                minMap.remove(size);
            } else {
                minMap.put(size, minV);
            }

            Set<String> newMaxV = maxMap.getOrDefault(size + 1, new HashSet<>());
            newMaxV.add(key);
            maxMap.put(size + 1, newMaxV);

            Set<String> newMinV = minMap.getOrDefault(size + 1, new HashSet<>());
            newMinV.add(key);
            minMap.put(size + 1, newMinV);

        } else {
            Set<String> maxV = maxMap.getOrDefault(1, new HashSet<>());
            maxV.add(key);
            maxMap.put(1, maxV);

            Set<String> minV = minMap.getOrDefault(1, new HashSet<>());
            minV.add(key);
            minMap.put(1, minV);

        }
        map.put(key, map.getOrDefault(key, 0) + 1);

    }

    public void dec(String key) {
        int size = map.get(key);
        Set<String> maxV = maxMap.get(size);
        Set<String> minV = minMap.get(size);
        maxV.remove(key);
        if (maxV.isEmpty()) {
            maxMap.remove(size);
        } else {
            maxMap.put(size, maxV);
        }
        minV.remove(key);
        if (minV.isEmpty()) {
            minMap.remove(size);
        } else {
            minMap.put(size, minV);
        }
        if (size == 1) {
            map.remove(key);
        } else {
            map.put(key, size - 1);
            Set<String> newMaxV = maxMap.getOrDefault(size - 1, new HashSet<>());
            newMaxV.add(key);
            maxMap.put(size - 1, newMaxV);

            Set<String> newMinV = minMap.getOrDefault(size - 1, new HashSet<>());
            newMinV.add(key);
            minMap.put(size - 1, newMinV);

        }


    }

    public String getMaxKey() {
        if (map.isEmpty()) {
            return "";
        }
        for (Map.Entry<Integer, Set<String>> entry : maxMap.entrySet()) {
            for (String s : entry.getValue()) {
                return s;
            }
        }
        return "";
    }

    public String getMinKey() {
        if (map.isEmpty()) {
            return "";
        }
        for (Map.Entry<Integer, Set<String>> entry : minMap.entrySet()) {
            for (String s : entry.getValue()) {
                return s;
            }
        }
        return "";
    }
}
