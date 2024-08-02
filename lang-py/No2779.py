"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/7/9 下午5:36:06
"""
from typing import List


class Solution:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        nums = sorted(nums)
        ans = 0
        l = 0
        i = 0
        while i < len(nums):
            if nums[l] + k * 2 >= nums[i]:
                ans = max(ans, i - l + 1)
            else:
                i -= 1
                l += 1
            i += 1
        return max(1, ans)
