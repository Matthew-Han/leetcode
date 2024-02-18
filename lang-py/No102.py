"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:39:34
"""
from collections import deque
from typing import Optional, List

from TreeNode import TreeNode


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        ans = []
        stack = deque[Optional[TreeNode]]()
        stack.append(root)
        while stack:
            limit = len(stack)
            sub = []
            for i in range(limit):
                curr = stack.popleft()
                sub.append(curr.val)
                if curr.left:
                    stack.append(curr.left)
                if curr.right:
                    stack.append(curr.right)
            ans.append(sub)
        return ans
