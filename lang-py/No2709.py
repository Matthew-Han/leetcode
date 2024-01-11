"""

  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/2 10:36:37
"""
from typing import List


class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        prices.sort()
        return money if money - prices[0] - prices[1] < 0 else money - prices[0] - prices[1]
