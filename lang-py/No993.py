"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:36:41
"""
from typing import Optional

from TreeNode import TreeNode


def dfs(root: Optional[TreeNode], p: int, depth: int) -> int:
    if root == None:
        return 0
    else:
        if root.val == p:
            return depth
        else:
            return dfs(root.left, p, depth + 1) + dfs(root.right, p, depth + 1)


def find(root: Optional[TreeNode], p: int) -> int:
    if root == None:
        return 0
    else:
        val = root.val if root.left and root.left.val == p else 0 + (
            root.val if root.right and root.right.val == p else 0)
        return val + find(root.left, p) + find(root.right, p)


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        return dfs(root, x, 0) == dfs(root, y, 0) and find(root, x) != find(root, y)
