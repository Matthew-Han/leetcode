import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SearchInsertPosition
 * @Description #35 搜索插入位置
 * @Author MatthewHan
 * @Date 2020/4/10 15:30
 * @Version 1.0
 **/
public class No35 {

    /**
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 6.27% 的用户
     * 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 5.03% 的用户
     * 别提了，垃圾中的战斗机。
     * 👴怎么写出这么垃圾的算法啊！感觉主要的问题就是没有一些数据结构和常用抽象算法的概念和基础
     * 赶紧去学下二分查找。
     * 多看看别人写的常用、通用算法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return i;
            }
        }
        for (int i = 0; i < list.size(); i++) {

            if (i + 1 < list.size() && list.get(i) < target && target < list.get(i + 1)) {
                list.add(i + 1, target);
                return i + 1;
            }
            if (target > list.getLast()) {
                list.add(list.size(), target);
                return list.size() - 1;
            }
            if (target < list.getFirst()) {
                list.addFirst(target);
                return 0;
            }
        }

        return 0;
    }
}
