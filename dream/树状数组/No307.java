package 树状数组;

import 默认模板.BinaryIndexedTree;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/7 16:00 07
 * @since 1.0
 **/
public class No307 {

    int[] nums;
    BinaryIndexedTree bit;

    /**
     * 区域和检索 - 数组可修改
     *
     * @param nums
     */
    public No307(int[] nums) {
        this.nums = nums;
        this.bit = new BinaryIndexedTree(nums);
    }

    public void update(int index, int val) {
        bit.update(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return bit.sum(left, right);
    }

}
