/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @since 2024/7/9 下午4:21:58
 **/
let nextGreaterElements = (nums) => {
    let ans = []
    for (let i = 0; i < nums.length; i++) {
        ans[i] = findIdx(nums, i)
    }
    return ans
};

let findIdx = (nums, idx) => {
    let i = (idx + 1) % nums.length
    while (i < nums.length) {
        if (i === idx) {
            return -1
        }
        if (nums[i] > nums[idx]) {
            return nums[i]
        }
        i = (i + 1) % nums.length
    }
    return -1
}