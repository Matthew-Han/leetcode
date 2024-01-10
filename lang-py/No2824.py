"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/2 10:58:00
"""
from typing import List

class Solution:
    def countPairs(self, nums: List[int], target: int) -> int:
        ans = 0
        nums.sort()
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] < target:
                    ans += 1
                else:
                    break
        return ans

