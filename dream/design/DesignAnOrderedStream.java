package design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/18 17:14
 **/
public class DesignAnOrderedStream {


    int size;
    int index;
    List<String> data;

    /**
     * #1656 设计有序流
     * 执行用时： 92 ms , 在所有 Java 提交中击败了 32.82% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 48.28% 的用户
     *
     * @param n
     */
    public DesignAnOrderedStream(int n) {
        data = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            data.add(null);
        }
        size = n + 1;
        index = 1;
    }

    public List<String> insert(int idKey, String value) {
        data.set(idKey, value);
        List<String> ans = new ArrayList<>();
        for (int i = index; i < size; i++) {
            if (data.get(i) == null) {
                break;
            }
            ans.add(data.get(i));
            index = i + 1;
        }
        return ans;
    }
}
