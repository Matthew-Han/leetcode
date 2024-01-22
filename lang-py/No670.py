"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/22 10:39:31
"""
from typing import List


class Solution:
    def maximumSwap(self, num: int) -> int:
        nums = list(list(str(num)))
        flag = False
        t1, t2 = 0, 0
        max = '0'
        for j in range(len(nums)):
            for i in range(len(nums) - 1, j, -1):
                if nums[i] > nums[j] and nums[i] > max:
                    t1 = i
                    t2 = j
                    max = nums[i]
                    flag = True
            if flag:
                break
        t = nums[t1]
        nums[t1] = nums[t2]
        nums[t2] = t
        return int(''.join(nums))
