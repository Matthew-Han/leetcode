package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName 双指针.MoveZeroes
 * @Description #283 移动零
 * @Author MatthewHan
 * @Date 2020/5/7 15:18
 * @Version 1.0
 **/
public class No283 {

    /**
     * 双指针，每次 i 指针的数和离它最近的非 0 指针（k 指针）的数交换，就可以保证非0数的顺序不会变。
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 5.62% 的用户
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int k;
        while (i < nums.length) {
            if (nums[i] == 0) {
                k = i + 1;
                while (k < nums.length) {
                    if (nums[k] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[k];
                        nums[k] = temp;
                        i++;
                    } else {
                        k++;
                    }
                }
                if (k == nums.length) {
                    break;
                }
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 方法一：额外空间
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 15.92% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 5.62% 的用户
     *
     * @param nums
     */
    public static void moveZeroesByArrays(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        int[] result = new int[nums.length];
        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }
        for (int num : nums) {
            if (num == 0) {
                list.add(num);
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        moveZeroes(new int[]{0, 0, 3});
    }
}
