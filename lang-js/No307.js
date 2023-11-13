/**
 * 区域和检索 - 数组可修改
 * @param nums
 * @constructor
 */
let NumArray = function (nums) {
    this.nums = nums;
    this.left = [];
    this.right = [];
    this.left[0] = nums[0];
    this.right[nums.length - 1] = nums[nums.length - 1];
    for (let i = 1; i < nums.length; i++) {
        this.left[i] = this.left[i - 1] + nums[i];
    }
    for (let i = nums.length - 2; i >= 0; i--) {
        this.right[i] = nums[i] + this.right[i + 1];
    }
};

NumArray.prototype.update = function (index, val) {

    for (let i = index; i < this.left.length; i++) {
        this.left[i] += val - this.nums[index];
    }

    for (let i = index; i >= 0; i--) {
        this.right[i] += val - this.nums[index];
    }

    this.nums[index] = val;
};


NumArray.prototype.sumRange = function (l, r) {
    return this.left[this.left.length - 1] - (l - 1 < 0 ? 0 : this.left[l - 1]) - (r + 1 >= this.right.length ? 0 : this.right[r + 1]);
};
