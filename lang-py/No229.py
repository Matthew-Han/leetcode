"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/11/28 10:40:18
"""
from collections import Counter
from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        d = Counter(nums)
        ans = []
        for kv in d.items():
            if kv[1] > len(nums) // 3:
                ans.append(kv[0])
        return ans