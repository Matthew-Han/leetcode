"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:42:33
"""
from collections import deque
from typing import Optional, List

from Node import Node


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root: return []
        ans = []
        q = deque[Optional[Node]]()
        q.append(root)
        while q:
            sub = []
            limit = len(q)
            for _ in range(limit):
                curr = q.popleft()
                sub.append(curr.val)
                for child in curr.children:
                    q.append(child)
            ans.append(sub)
        return ans
