"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/2/21 12:44:04
"""
from typing import List


class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        l, r = [], []
        for i in range(len(arrays)):
            l.append(arrays[i][0])
            r.append(arrays[i][-1])
        l.sort()
        r.sort(reverse=True)
        ans = 0
        for i in range(len(arrays)):
            ans = max(ans, abs((r[1] if r[0] == arrays[i][-1] else r[0]) - arrays[i][0]))
            ans = max(ans, abs(arrays[i][-1] - (l[1] if l[0] == arrays[i][0] else l[0])))
        return ans
