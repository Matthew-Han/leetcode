"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:40:18
"""
from collections import deque
from typing import Optional, List

from TreeNode import TreeNode


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        q: deque = deque[Optional[TreeNode]]()
        while q or root:
            if root:
                q.append(root)
                root = root.left
            else:
                root = q.pop()
                ans.append(root.val)
                root = root.right
        return ans
