"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:42:00
"""
from collections import deque
from typing import Optional, List

from TreeNode import TreeNode


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        ans = []
        q = deque[Optional[TreeNode]]()
        q.append(root)
        depth = 0
        while q:
            sub = []
            limit = len(q)
            for _ in range(limit):
                curr = q.popleft()
                sub.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            ans.append(sub if (depth & 1) == 0 else list(reversed(sub)))
            depth += 1
        return ans
