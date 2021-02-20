import java.util.*;

/**
 * @ClassName DegreeOfAnArray
 * @Description #697 数组的度
 * @Author MatthewHan
 * @Date 2020/5/29 12:42
 * @Version 1.0
 **/
public class DegreeOfAnArray {

    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 93.52% 的用户
     * 内存消耗： 42 MB , 在所有 Java 提交中击败了 71.30% 的用户
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        int[] bucket = new int[50000];
        int max = 0;
        int ans = Integer.MAX_VALUE;
        // 存放众数的值（多个）
        List<Integer> list = new ArrayList<>();
        // 存放 nums[i] 的两端 index
        Map<Integer, int[]> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 初始化
            if (!cache.containsKey(nums[i])) {
                int[] v = new int[]{i, i};
                cache.put(nums[i], v);
            }

            bucket[nums[i]]++;
            if (max == bucket[nums[i]]) {
                list.add(nums[i]);

                // 更新右端点
                int[] v = cache.get(nums[i]);
                v[1] = i;
                cache.put(nums[i], v);
            } else if (max < bucket[nums[i]]) {
                max = bucket[nums[i]];
                list.clear();
                list.add(nums[i]);

                // 更新右端点
                int[] v = cache.get(nums[i]);
                v[1] = i;
                cache.put(nums[i], v);
            }


        }
        for (Integer n : list) {
            int[] v = cache.get(n);
            ans = Math.min(ans, v[1] - v[0] + 1);
            // 这个就是最小数,提前退出,速度快不少
            if (ans == max) {
                return ans;
            }
        }
        return ans;
    }

    public int len(int[] nums, int n) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == n) {
                right = i;
                break;
            }
        }
        return right - left + 1;
    }


    /**
     * 执行用时 : 52 ms , 在所有 Java 提交中击败了 20.23% 的用户
     * 内存消耗 : 45 MB , 在所有 Java 提交中击败了 6.25% 的用户
     *
     * @param nums
     * @return
     */
    public static int findShortestSubArrayOld(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length * 4 / 3 + 1);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = -1;
        List<Integer> maxArray = new ArrayList<>();
        for (Integer value : map.values()) {
            max = Math.max(value, max);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                maxArray.add(entry.getKey());
            }
        }
        int len = nums.length;
        for (Integer integer : maxArray) {
            int low = 0;
            int high = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == integer) {
                    low = i;
                    break;
                }
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] == integer) {
                    high = j;
                    break;
                }
            }
            len = Math.min((high - low + 1), len);

        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArrayOld(new int[]{1, 2, 1, 2, 3, 2}));
    }
}
