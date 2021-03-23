package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/23 10:23
 **/
public class FlattenNestedListIterator implements Iterator<Integer> {

    public interface NestedInteger {

        /**
         * @return true if this NestedInteger holds a single integer, rather than a nested list
         */
        public boolean isInteger();

        /**
         * @return the single integer that this NestedInteger holds, if it holds a single integer
         * Return null if this NestedInteger holds a nested list
         */
        public Integer getInteger();


        /**
         * @return the nested list that this NestedInteger holds, if it holds a nested list
         * Return null if this NestedInteger holds a single integer
         */
        public List<NestedInteger> getList();
    }

    List<Integer> data;
    int index;

    /**
     * #341 扁平化嵌套列表迭代器
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 91.05% 的用户
     * 内存消耗： 41 MB , 在所有 Java 提交中击败了 23.05% 的用户
     *
     * @param nestedList
     */
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.data = new ArrayList<>();
        this.index = 0;
        init(nestedList);
    }

    public void init(List<NestedInteger> list) {
        for (NestedInteger curr : list) {
            if (curr.isInteger()) {
                data.add(curr.getInteger());
            } else {
                init(curr.getList());
            }
        }

    }

    @Override
    public Integer next() {
        return data.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < data.size();
    }

}
