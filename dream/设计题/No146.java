package 设计题;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName LruCache
 * @Description #146 LRU缓存机制
 * @Author MatthewHan
 * @Date 2020/9/9 16:52
 * @Version 1.0
 **/
public class No146 {

    private final int capacity;
    private final Queue<Integer[]> data;

    /**
     * Queue改成Map，获取<k,v>就快了，不用for了
     * 执行用时： 712 ms , 在所有 Java 提交中击败了 5.03% 的用户
     * 内存消耗： 48.2 MB , 在所有 Java 提交中击败了 29.12% 的用户
     *
     * @param capacity
     */
    public No146(int capacity) {
        this.capacity = capacity;
        data = new LinkedList<>();
    }

    public int get(int key) {
        int value = -1;
        for (Integer[] pair : data) {
            if (pair[0] == key) {
                value = pair[1];
                data.remove(pair);
                break;
            }
        }
        if (value != -1) {
            data.offer(new Integer[]{key, value});
        }
        System.out.println("data1 = " + data);
        return value;
    }

    public void put(int key, int value) {
        int size = data.size();
        if (size < capacity) {
            for (Integer[] pair : data) {
                if (pair[0] == key) {
                    data.remove(pair);
                    break;
                }
            }
            data.offer(new Integer[]{key, value});
        } else {
            boolean flag = false;
            for (Integer[] pair : data) {
                if (pair[0] == key) {
                    data.remove(pair);
                    flag = true;
                    break;
                }
            }
            data.offer(new Integer[]{key, value});
            if (!flag) {
                data.poll();
            }
        }
        System.out.println("data2 = " + data);
    }

    /**
     * 解法二
     * 比解法一稍微快一点, Hash 表少了循环判断 k - v 的存在
     * 主要利用 <code>LinkedHashMap</code> 和 有序列表 <code>List</code> 来维护
     * LinkedHashMap 维护缓存数据
     * List 维护数据的有序性
     *
     * @see LinkedHashMap
     */
    public static class LruCache {

        int limit;
        Map<Integer, Integer> data;
        Queue<Integer> keys;

        public LruCache(int capacity) {
            limit = capacity;
            keys = new LinkedList<>();
            data = new LinkedHashMap<>(capacity * 4 / 3 + 1);
        }

        public int get(int key) {
            if (data.get(key) == null) {
                return -1;
            }
            Integer v = data.get(key);
            keys.remove(key);
            keys.add(key);
            data.remove(key);
            data.put(key, v);
            return v;
        }

        public void put(int key, int value) {
            /* 判断一: data 为空 */
            if (data.isEmpty()) {
                data.put(key, value);
                keys.add(key);
                return;
                /* 判断二: data 不为空, 但是长度小于 capacity */
            } else if (data.size() < limit) {
                if (data.containsKey(key)) {
                    data.remove(key);
                    keys.remove(key);
                }
                keys.add(key);
                data.put(key, value);
                return;
            }
            /* 判断三: data 目前长度为 capacity 需要分两种情况: 1. 当前缓存中有该 k - v; 2. 当前缓存中妹有该 k - v */
            if (data.containsKey(key)) {
                data.remove(key);
                keys.remove(key);
            } else {
                data.remove(keys.peek());
                keys.poll();
            }
            keys.add(key);
            data.put(key, value);

        }
    }


}
