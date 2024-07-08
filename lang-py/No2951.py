"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/5/29 上午10:57:13
"""
from typing import List


class Solution:
    def findPeaks(self, mountain: List[int]) -> List[int]:
        ans = []
        for i in range(1, len(mountain) - 1):
            if mountain[i] > mountain[i - 1] and mountain[i] > mountain[i + 1]:
                ans.append(i)
        return ans
