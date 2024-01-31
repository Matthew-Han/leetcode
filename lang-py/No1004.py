"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/31 16:06:43
"""
from typing import List


class Solution:

    def longestOnes(self, nums: List[int], k: int) -> int:
        ans = 0
        ids = list(i for i, e in enumerate(nums) if e == 0)
        if len(ids) == 0:
            return len(nums)
        if k == 0:
            for i in range(1, len(ids)):
                ans = max(ans, ids[i] - ids[i - 1] - 1)
            ans = max(ans, ids[0])
            ans = max(ans, len(nums) - 1 - ids[-1])
            return ans
        n, i, j = len(nums), -1, k - 1
        while i < len(ids):
            # 左边界
            left = ids[i] if i > -1 else -1
            # 右边界
            right = ids[min(len(ids) - 1, j)]
            if right < n - 1 and nums[right + 1] == 1:
                right = n - 1 if j + 1 >= len(ids) else ids[j + 1] - 1
            ans = max(ans, right - left)
            i += 1
            j += 1
        return ans
