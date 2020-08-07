package 双指针;

import java.util.*;

/**
 * @ClassName 双指针.IntersectionOfTwoArrays
 * @Description #349 两个数组的交集
 * @Author MatthewHan
 * @Date 2020/5/9 11:16
 * @Version 1.0
 **/
public class IntersectionOfTwoArrays {

    /**
     * 执行用时 : 8 ms , 在所有 Java 提交中击败了 17.15% 的用户
     * 内存消耗 : 40.3 MB , 在所有 Java 提交中击败了 5.72% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersectionPro(int[] nums1, int[] nums2) {
        Set<Integer> temp = new HashSet<>();
        for (int value : nums1) {
            for (int i : nums2) {
                if (i == value) {
                    temp.add(i);
                }
            }
        }
        int[] result = new int[temp.size()];
        int i = 0;
        for (Integer integer : temp) {
            result[i] = integer;
            i++;
        }
        return result;
    }

    /**
     * 执行用时 : 8 ms , 在所有 Java 提交中击败了 17.15% 的用户
     * 内存消耗 : 39.5 MB , 在所有 Java 提交中击败了 5.72% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(nums1.length * 4 / 3 + 1);
        Set<Integer> set2 = new HashSet<>(nums2.length * 4 / 3 + 1);
        List<Integer> list = new ArrayList<>(nums1.length + nums2.length);
        Map<Integer, Integer> map = new HashMap<>();
        // 通过set集合去除原数组重复的元素
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        // 将2个set集合都装载到list中
        list.addAll(set1);
        list.addAll(set2);
        // 将list中的元素装载到map中，value是相同key的数量
        for (Integer integer : list) {
            map.put(integer, map.getOrDefault(integer, 0) + 1);
        }
        List<Integer> temp = new ArrayList<>();
        // map中数量大于2的元素即为两个原数组相同的元素，也就是交集
        map.forEach((k, v) -> {
            if (v > 1) {
                temp.add(k);
            }
        });
        /*
         * 因为不能确定上面不能确定交集元素的个数，所以无法直接定义数组容量大小在循环中赋值，只能先装到temp列表
         * 根据temp的长度再实例化一个结果int数组
         */
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectionPro(new int[]{1, 3, 2, 2, 1}, new int[]{2, 2, 3})));
    }
}
