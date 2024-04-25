"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/3/14 15:35:30
"""
from typing import List


class Solution:
    def maxArrayValue(self, nums: List[int]) -> int:
        ans = nums[0]
        tmp = nums[-1]
        for i in range(len(nums), 0, -1):
            tmp = nums[i - 1] + tmp if nums[i - 1] <= tmp else nums[i - 1]
            ans = max(ans, tmp)
        return ans
