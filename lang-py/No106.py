"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/26 09:56:07
"""
import sys
from typing import List, Optional

from TreeNode import TreeNode


def build(left: int, right: int, inorder: List[int], postorder: List[int], postorder_idx,
          node: Optional[TreeNode]) -> None:
    if left < right:
        mid = inorder.index(node.val)
        nxt_l = -1
        for idx in range(left, mid):
            nxt_l = max(nxt_l, postorder_idx[inorder[idx]])
        nxt_r = -1
        for idx in range(mid + 1, right):
            nxt_r = max(nxt_r, postorder_idx[inorder[idx]])
        if nxt_l != -1:
            node.left = TreeNode(postorder[nxt_l])
        if nxt_r != -1:
            node.right = TreeNode(postorder[nxt_r])
        build(left, mid, inorder, postorder, postorder_idx, node.left)
        build(mid + 1, right, inorder, postorder, postorder_idx, node.right)


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        root = TreeNode(postorder[-1])
        postorder_idx = dict(map(reversed, enumerate(postorder)))
        build(0, len(postorder), inorder, postorder, postorder_idx, root)
        return root
