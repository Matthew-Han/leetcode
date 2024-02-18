"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:38:25
"""
from typing import Optional, List

from TreeNode import TreeNode


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        return [] if root is None else self.postorderTraversal(root.left) + self.postorderTraversal(root.right) + [
            root.val]
