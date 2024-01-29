"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/29 09:09:41
"""
from typing import List


class Solution:
    def maxNumberOfAlloys(self, n: int, k: int, budget: int, composition: List[List[int]], stock: List[int],
                          cost: List[int]) -> int:
        ans, left, right = -1, 0, 2 * 10 ** 8
        while left <= right:
            mid = (left + right) >> 1
            check = False
            for i in range(k):
                speed = 0
                for j in range(n):
                    speed += max(composition[i][j] * mid - stock[j], 0) * cost[j]
                if speed <= budget:
                    ans = max(ans, mid)
                    check = True
            if check:
                left = mid + 1
            else:
                right = mid - 1
        return ans


