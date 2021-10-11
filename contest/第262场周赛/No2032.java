package 第262场周赛;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/11 10:24
 * @since 1.0
 **/
public class No2032 {

    /**
     * 至少在两个数组中出现的值
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @return
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> ans = new HashSet<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    ans.add(i);
                    break;
                }
            }
        }
        for (int i : nums1) {
            for (int j : nums3) {
                if (i == j) {
                    ans.add(i);
                    break;
                }
            }
        }
        for (int i : nums2) {
            for (int j : nums3) {
                if (i == j) {
                    ans.add(i);
                    break;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
