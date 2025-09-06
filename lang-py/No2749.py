"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/9/5 10:23:02
"""


class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        k = 1
        while True:
            diff = num1 - k * num2
            if diff < k:
                return -1
            if k >= diff.bit_count():
                return k
            k += 1
