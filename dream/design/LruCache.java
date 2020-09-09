package design;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LruCache
 * @Description #146 LRU缓存机制
 * @Author MatthewHan
 * @Date 2020/9/9 16:52
 * @Version 1.0
 **/
public class LruCache {

    private final int capacity;
    private final Queue<Pair<Integer, Integer>> data;

    /**
     * Queue改成Map，获取<k,v>就快了，不用for了
     * 执行用时： 712 ms , 在所有 Java 提交中击败了 5.03% 的用户
     * 内存消耗： 48.2 MB , 在所有 Java 提交中击败了 29.12% 的用户
     *
     * @param capacity
     */
    public LruCache(int capacity) {
        this.capacity = capacity;
        data = new LinkedList<>();
    }

    public int get(int key) {
        int value = -1;
        for (Pair<Integer, Integer> pair : data) {
            if (pair.getKey() == key) {
                value = pair.getValue();
                data.remove(pair);
                break;
            }
        }
        if (value != -1) {
            data.offer(new Pair<>(key, value));
        }
        System.out.println("data1 = " + data);
        return value;
    }

    public void put(int key, int value) {
        int size = data.size();
        if (size < capacity) {
            for (Pair<Integer, Integer> pair : data) {
                if (pair.getKey() == key) {
                    data.remove(pair);
                    break;
                }
            }
            data.offer(new Pair<>(key, value));
        } else {
            boolean flag = false;
            for (Pair<Integer, Integer> pair : data) {
                if (pair.getKey() == key) {
                    data.remove(pair);
                    flag = true;
                    break;
                }
            }
            data.offer(new Pair<>(key, value));
            if (!flag) {
                data.poll();
            }
        }
        System.out.println("data2 = " + data);
    }


}
