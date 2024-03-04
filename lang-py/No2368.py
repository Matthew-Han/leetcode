"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/3/4 16:21:50
"""
from collections import defaultdict, deque
from typing import List


class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        map = defaultdict[int, List[int]]()
        vis = [False] * n
        flag = set(restricted)
        ans = 0
        for edge in edges:
            v1 = map.setdefault(edge[0], [])
            v2 = map.setdefault(edge[1], [])
            v1.append(edge[1])
            v2.append(edge[0])
            map[edge[0]] = v1
            map[edge[1]] = v2
        q = deque()
        q.append(0)
        while q:
            curr = q.pop()
            ans += 1
            vis[curr] = True
            valid_list = list(filter(lambda x: x not in flag and not vis[x], map.get(curr)))
            for valid in valid_list:
                q.append(valid)
        return ans
