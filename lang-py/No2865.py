"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/29 09:08:47
"""
from typing import List


class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        ans = 0
        for i in range(len(maxHeights)):
            ans = max(ans, self.sum_of_the_bitch(maxHeights, i))
        return ans

    def sum_of_the_bitch(self, maxHeights: List[int], idx: int) -> int:
        ans = 0
        min_height = maxHeights[idx]
        for i in range(idx - 1, -1, -1):
            min_height = min(maxHeights[i], min_height)
            ans += min_height
        min_height = maxHeights[idx]
        for i in range(idx + 1, len(maxHeights)):
            min_height = min(maxHeights[i], min_height)
            ans += min_height
        return ans + maxHeights[idx]
