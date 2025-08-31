"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/8/29 23:35:55
"""


class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        x1 = (n + 1) // 2
        y1 = n - x1
        x2 = (m + 1) // 2
        y2 = m - x2
        return x1 * y2 + x2 * y1
