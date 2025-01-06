"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/12/12 10:09:41
"""
from copy import deepcopy


class Solution:
    def knightDialer(self, n: int) -> int:
        mem = {0: [4, 6], 1: [6, 8], 2: [7, 9], 3: [4, 8], 4: [0, 3, 9], 6: [0, 1, 7], 7: [2, 6], 8: [1, 3], 9: [2, 4]}
        cnt = {0: 1, 1: 1, 2: 1, 3: 1, 4: 1, 6: 1, 7: 1, 8: 1, 9: 1}
        ans = 10
        mod = 10 ** 9 + 7
        for e in range(1, n):
            ans = 0
            tmp = {0: 0, 1: 0, 2: 0, 3: 0, 4: 0, 6: 0, 7: 0, 8: 0, 9: 0}
            for kv in cnt.items():
                gg = len(mem[kv[0]]) % mod * kv[1]
                ans += gg
                for e in mem[kv[0]]:
                    tmp[e] += gg // len(mem[kv[0]])
            cnt = tmp
        return ans % mod
