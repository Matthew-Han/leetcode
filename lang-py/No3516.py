"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/9/4 00:20:20
"""


class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        return 0 if abs(x - z) == abs(y - z) else 1 if abs(x - z) < abs(y - z) else 2
