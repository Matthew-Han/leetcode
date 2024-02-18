"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:49:43
"""
from collections import deque
from typing import List

from Node import Node


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if not root: return []
        ans = []
        q = deque['Node']()
        q.append(root)
        while q:
            curr = q.pop()
            ans.append(curr.val)
            q.extend(reversed(curr.children))
        return ans
