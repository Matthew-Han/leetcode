package leetcode.eazy;

import java.util.Arrays;

/**
 * @ClassName RemoveElement
 * @Description #27 移除元素
 * @Author MatthewHan
 * @Date 2020/4/10 09:47
 * @Version 1.0
 **/
public class RemoveElement {

    /**
     * i指针作为指定的val，从左向右
     * j指针每次初始化复位到i指针的位置，从左向右，当出现不是val的值的时候，与i指针对应的值交换
     * 当j指针走到数组的最后一位时，return i指针下标
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int i;
        int j;
        for (i=0; i<nums.length; i++) {
            if (nums[i] == val) {
                for (j=i; j<nums.length; j++) {
                    if (nums[j] != val) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                    if (j+1 == nums.length){
                        return i;
                    }
                }
            }
            System.out.println("i:"+i);
        }
        System.out.println("i++:"+i);
        return i;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,7,0,2,2,3};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));

    }
}
