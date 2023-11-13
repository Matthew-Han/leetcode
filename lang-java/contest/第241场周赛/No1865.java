package 第241场周赛;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/18 10:57
 * @description
 * @since 1.0.0
 **/
public class No1865 {

    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> cntMap;

    /**
     * #1865 找出和为指定值的下标对
     *
     * @param nums1
     * @param nums2
     */
    public No1865(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        cntMap = new HashMap<>();

        // 初始化
        for (int k : nums2) {
            for (int i : nums1) {
                int c = i + k;
                cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
            }
        }
    }

    public void add(int index, int val) {
        for (int j : nums1) {
            int k = j + nums2[index];
            cntMap.put(k, cntMap.getOrDefault(k, 0) - 1);
            int nk = k + val;
            cntMap.put(nk, cntMap.getOrDefault(nk, 0) + 1);
        }
        nums2[index] += val;
    }

    public int count(int tot) {
        return cntMap.get(tot) == null ? 0 : cntMap.get(tot);
    }
}
