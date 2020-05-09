import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName IntersectionOfTwoArraysII
 * @Description #350 两个数组的交集 II
 * @Author MatthewHan
 * @Date 2020/5/9 14:30
 * @Version 1.0
 **/
public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>(nums1.length);
        List<Integer> list2 = new ArrayList<>(nums2.length);
        List<Integer> list3 = new ArrayList<>();
        for (int i : nums1) {
            list1.add(i);
        }
        for (int i : nums2) {
            list2.add(i);
        }


        int[] result = new int[list3.size()];
        for (int i = 0; i < list3.size(); i++) {
            result[i] = list3.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1}, new int[]{1, 1})));
    }
}
