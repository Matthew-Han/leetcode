"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/27 10:16:44
"""
from typing import Optional

from TreeNode import TreeNode


class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root:
            if root.val < low:
                return self.rangeSumBST(root.right, low, high)
            elif root.val > high:
                return self.rangeSumBST(root.left, low, high)
            else:
                return root.val + self.rangeSumBST(root.left, low, high) + self.rangeSumBST(root.right, low, high)
        else:
            return 0
