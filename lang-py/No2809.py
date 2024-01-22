"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/19 10:42:28
"""
from typing import List


class Solution:
    def minimumTime(self, nums1: List[int], nums2: List[int], x: int) -> int:
        delta = [0] * len(nums1)
        for i in range(len(nums1)):
            delta[i] = nums1[i] + nums2[i]
        print(delta)

        return 1
