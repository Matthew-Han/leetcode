"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/7/8 下午4:13:27
"""
from typing import List


class Solution:
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        l = 0
        ans = 0
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                ans += (i - l) * (i - l - 1) // 2
                l = i
            if i == len(nums) - 1 and nums[i] != nums[i - 1]:
                ans += (i - l + 1) * (i - l) // 2
        return ans + len(nums)
