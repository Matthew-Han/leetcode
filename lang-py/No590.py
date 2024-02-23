"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/23 12:39:51
"""
from collections import deque
from typing import List

from Node import Node


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if root:
            ans = []
            q = deque()
            q.append(root)
            while q:
                curr = q.pop()
                ans.append(curr.val)
                q.extend(curr.children)
            return list(reversed(ans))
        else:
            return []
