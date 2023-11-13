package 设计题;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/22 11:06 22
 * @since 1.0
 **/
public class No380 {

    List<Integer> list;
    Map<Integer, Integer> map;

    /**
     * O(1) 时间插入、删除和获取随机元素
     */
    public No380() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(idx, last);
            list.remove(list.size() - 1);
            map.put(last, idx);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int r = new Random().nextInt(list.size());
        return list.get(r);
    }


}
