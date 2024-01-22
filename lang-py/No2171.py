"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/18 09:44:21
"""
from typing import List


class Solution:
    def minimumRemoval(self, beans: List[int]) -> int:
        beans.sort()
        tot = sum(beans)
        return min(tot - bean * (len(beans) - idx) for idx, bean in enumerate(beans))
