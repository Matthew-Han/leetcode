package 二分查找;

import java.util.TreeSet;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/7/5 10:39 05
 * @since 1.0
 **/
public class No729 {

    TreeSet<int[]> set;

    /**
     * 我的日程安排表 I
     */
    public No729() {
        set = new TreeSet<>((o1, o2) -> {
            if (o1[1] <= o2[0]) {
                return -1;
            } else if (o1[0] >= o2[1]) {
                return 1;
            } else {
                return 0;
            }
        });
    }

    public boolean book(int start, int end) {
        return set.add(new int[]{start, end});
    }
}
