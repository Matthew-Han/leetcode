"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/5/30 上午9:33:06
"""
from collections import defaultdict, Counter


class Solution:
    def maximumLength(self, s: str) -> int:
        map = defaultdict[str, int]()
        for i in range(len(s) - 2, 0, -1):
            l = 0
            for j in range(i, len(s) + 1):
                prev = s[l:j]
                map.setdefault(prev, 0)
                map[prev] += 1
                if len(Counter(prev).values()) == 1 and map[prev] >= 3:
                    return i
                l += 1
        return -1
