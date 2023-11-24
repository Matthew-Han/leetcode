/**
 * 统计和小于目标的下标对数目
 * @param nums
 * @param target
 * @returns {number}
 */
let countPairs = (nums, target) => {
    nums.sort((o1, o2) => o1 - o2);
    let sum = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] < target) {
                sum++;
            } else {
                break;
            }
        }
    }
    return sum;
};