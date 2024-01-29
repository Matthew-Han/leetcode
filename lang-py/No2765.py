"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/29 09:08:18
"""
from typing import List


class Solution:
    def alternatingSubarray(self, nums: List[int]) -> int:
        diff = 1
        ans = 0
        tmp = 1
        for i in range(1, len(nums)):
            if nums[i] - diff == nums[i - 1]:
                tmp += 1
                diff = -diff
            else:
                if nums[i] - 1 == nums[i - 1]:
                    tmp = 2
                    diff = -1
                else:
                    tmp = 1
                    diff = 1
            ans = max(ans, tmp)
        return ans if ans > 1 else -1
