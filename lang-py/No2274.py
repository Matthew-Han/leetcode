"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/1/6 09:08:35
"""
from typing import List


class Solution:
    def maxConsecutive(self, bottom: int, top: int, special: List[int]) -> int:
        special.append(top + 1)
        special.append(bottom - 1)
        special.sort()
        ans = 0
        for i in range(1, len(special)):
            ans = max(special[i] - special[i - 1] - 1, ans)
        return ans
