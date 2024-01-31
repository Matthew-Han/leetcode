"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/31 11:14:07
"""
from typing import List


class Solution:
    def distinctDifferenceArray(self, nums: List[int]) -> List[int]:
        pre = set()
        for i in range(len(nums)):
            pre.add(nums[i])
            nums[i] = len(pre) - (len(set(nums[(i + 1):])) if i < len(nums) - 1 else 0)
        return nums
