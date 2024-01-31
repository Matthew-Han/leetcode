from collections import defaultdict
from typing import List


class Solution:
    def minimumSeconds(self, nums: List[int]) -> int:
        ans = 0x3f3f3f3f
        map = defaultdict(List[int])
        for i, num in enumerate(nums):
            v = map.get(num, [])
            v.append(i)
            map[num] = v
        for item in map.values():
            tmp = 0
            if len(item) == 1:
                tmp = max(item[0], len(nums))
            else:
                for i, e in enumerate(item):
                    nxt_i = item[(i + 1) % len(item)]
                    if nxt_i != e:
                        tmp = max(tmp, abs((nxt_i if nxt_i > e else nxt_i + len(nums)) - e))
                    else:
                        tmp = 0x3f3f3f3f
            ans = min(ans, tmp // 2)
        return ans
