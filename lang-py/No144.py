"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:41:30
"""
from collections import deque
from typing import Optional, List

from TreeNode import TreeNode


class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        ans = []
        q = deque['Node']()
        q.append(root)
        while q:
            curr = q.pop()
            ans.append(curr.val)
            if curr.right:
                q.append(curr.right)
            if curr.left:
                q.append(curr.left)
        return ans
