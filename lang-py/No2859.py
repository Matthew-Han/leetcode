"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/29 09:09:23
"""
from typing import List


class Solution:
    def sumIndicesWithKSetBits(self, nums: List[int], k: int) -> int:
        return sum(e if int.bit_count(i) == k else 0 for i, e in enumerate(nums))
