"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/6 09:43:09
"""
import sys
from collections import deque
from typing import List


class Solution:
    # 算是自己尝试的第 N 次 dp? 但是很有纪念意义!
    def maxResult(self, nums: List[int], k: int) -> int:
        dp, pq = [-sys.maxsize] * len(nums), deque([0])
        dp[0] = nums[0]
        for i in range(1, len(nums)):
            while i - pq[0] > k:
                pq.popleft()
            dp[i] = dp[pq[0]] + nums[i]
            while pq and dp[pq[-1]] <= dp[i]:
                pq.pop()
            pq.append(i)
        return dp[-1]
