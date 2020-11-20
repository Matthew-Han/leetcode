package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/20 15:00
 **/
public class FlattenNestedListIterator implements Iterator<Integer> {

    private interface NestedInteger {

        /**
         * 如果此NestedInteger持有单个整数而不是嵌套列表，则返回true。
         *
         * @return
         */
        boolean isInteger();

        /**
         * 如果此NestedInteger持有单个整数，则返回此整数
         * 如果此NestedInteger包含嵌套列表，则返回null
         *
         * @return
         */
        Integer getInteger();

        /**
         * 返回此NestedInteger所保存的嵌套列表（如果它包含嵌套列表）
         * 如果此NestedInteger包含单个整数，则返回null
         *
         * @return
         */
        List<NestedInteger> getList();
    }

    int index;

    private final List<Integer> res;

    /**
     * #341 扁平化嵌套列表迭代器
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 98.02% 的用户
     * 内存消耗： 40.7 MB , 在所有 Java 提交中击败了 87.33% 的用户
     *
     * @param nestedList
     */
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        index = 0;
        this.res = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            dfs(nestedInteger);
        }
    }

    @Override
    public Integer next() {
        return res.get(index++);
    }


    @Override
    public boolean hasNext() {
        return index < res.size();
    }

    public void dfs(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            res.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger integer : nestedInteger.getList()) {
                dfs(integer);
            }
        }
    }

}
