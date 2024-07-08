"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/7/2 下午4:52:55
"""
from typing import List


class Solution:
    def maximumPrimeDifference(self, nums: List[int]) -> int:
        l, r = 0, 0
        for i in range(len(nums) - 1, -1, -1):
            if self.is_prime(nums[i]):
                r = i
                break
        for i in range(len(nums)):
            if self.is_prime(nums[i]):
                l = i
                break
        return r - l

    def is_prime(self, n: int):
        if n <= 1:
            return False  # 1 和负数都不是质数
        if n == 2:
            return True  # 2 是质数
        if n % 2 == 0:
            return False  # 排除所有偶数
        # 检测从 3 到 sqrt(n) 的所有奇数
        for i in range(3, int(n ** 0.5) + 1, 2):
            if n % i == 0:
                return False
        return True
