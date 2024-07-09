"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/7/9 下午3:21:24
"""
from collections import defaultdict, OrderedDict
from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        return list(self.find_idx(nums, idx) for idx in range(len(nums)))

    def find_idx(self, nums: List[int], idx: int) -> int:
        i = (idx + 1) % len(nums)
        while i < len(nums):
            if i == idx:
                return -1
            if nums[i] > nums[idx]:
                return nums[i]
            i = (i + 1) % len(nums)
