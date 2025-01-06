"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/12/13 10:28:01
"""
from typing import List


class Solution:
    def maxSpending(self, values: List[List[int]]) -> int:
        m = len(values)
        n = len(values[0])
        ans = 0
        points = [n - 1] * m
        for d in range(m * n):
            min = 0x3f3f3f3f
            p = 0
            for i in range(m):
                if points[i] >= 0 and min > values[i][points[i]]:
                    min = values[i][points[i]]
                    p = i
            ans += (d + 1) * min
            points[p] -= 1
        return ans
