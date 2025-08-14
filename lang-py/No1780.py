"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/8/14 03:36:56
"""
from collections import defaultdict


class Solution:
    def __init__(self):
        self.res = False
        self.mem = set()

    def checkPowersOfThree(self, n: int) -> bool:
        self.dfs(0, 0, n)
        return self.res

    def dfs(self, s: int, ans: int, simple: int) -> None:
        if self.res:
            return
        for i in range(s, 15):
            if ans + 3 ** i in self.mem:
                return
            if ans + 3 ** i == simple:
                self.res = True
                return
            elif ans + 3 ** i < simple:
                self.mem.add(ans + 3 ** i)
                self.dfs(i + 1, ans, simple)
            self.dfs(i + 1, ans + 3 ** i, simple)


