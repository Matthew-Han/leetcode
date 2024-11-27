"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/11/27 09:15:05
"""
from typing import List


class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        length = len(colors)
        cnt = 0
        i = 0
        flag = True
        while i < len(colors):
            if flag:
                for j in range(i, i + k - 1):
                    if colors[(j + 1) % length] == colors[j % length]:
                        i = j + 1
                        flag = False
                        break
                if flag:
                    flag = False
                    cnt += 1
                    i += 1
                else:
                    flag = True
            else:
                if colors[(i + k - 2) % length] != colors[(i + k - 1) % length]:
                    cnt += 1
                else:
                    flag = True
                i += 1
        return cnt

