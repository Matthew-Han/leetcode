"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/9/6 20:08:38
"""
from typing import List


class Solution:
    def minOperations(self, queries: List[List[int]]) -> int:
        ans = 0
        for query in queries:
            res = 0
            l, r = query[0], query[1]
            tmp = [l]
            x = 4
            while x < 10e9:
                if x > r:
                    break
                if x >= l:
                    tmp.append(x)
                x *= 4
            tmp.append(r)
            for i in range(1, len(tmp)):
                diff = tmp[i] - tmp[i - 1]
                res += diff * self.log4(tmp[i - 1])
                print(res)
            res += self.log4(tmp[-1])
            ans += (res + 1) // 2
        return ans

    def log4(self, num: int) -> int:
        res = 0
        while num > 0:
            res += 1
            num >>= 2
        return res

