"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:40:50
"""
from collections import deque
from typing import Optional, List

from TreeNode import TreeNode


class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        ans = []
        stack = deque()
        stack.append(root)
        while stack:
            limit = len(stack)
            sub = []
            for i in range(limit):
                curr = stack.popleft()
                if curr.left:
                    stack.append(curr.left)
                if curr.right:
                    stack.append(curr.right)
                sub.append(curr.val)
            ans.append(sub)
        return list(reversed(ans))
