"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/7/5 上午11:00:13
"""
from collections import defaultdict
from functools import cache, lru_cache
from typing import List


class Solution:
    def specialPerm(self, nums: List[int]) -> int:
        mod = 10 ** 9 + 7
        n = len(nums)

        @cache
        def dfs(state, i):
            if state == (1 << i):
                return 1
            res = 0
            x = nums[i]
            for j, y in enumerate(nums):
                if i == j or not state >> j & 1:
                    continue
                if x % y != 0 and y % x != 0:
                    continue
                res = (res + dfs(state ^ (1 << i), j)) % mod
            return res

        return sum(dfs((1 << n) - 1, i) for i in range(n)) % mod
