"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/4/18 下午3:53:01
"""
from collections import Counter, defaultdict
from typing import List


class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        map = defaultdict(int, Counter(changed).items())
        ans = []
        changed = sorted(changed, reverse=True)
        for e in changed:
            if map[e] != 0:
                map[e] = map[e] - 1
                if e % 2 != 0 or e // 2 not in map:
                    return []
                else:
                    ans.append(e // 2)
                    map[e // 2] = map[e // 2] - 1
        return ans if len(changed) % 2 == 0 else []
