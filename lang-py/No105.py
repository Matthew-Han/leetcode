"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/23 09:20:36
"""
import sys
from typing import List, Optional
from TreeNode import TreeNode


def build(preorder_idx: dict, inorder_idx: dict, inorder: List[int], left: int, right: int,
          node: Optional[TreeNode]) -> None:
    if left < right:
        mid = inorder_idx[node.val]
        l_nxt = find_next(preorder_idx, inorder[left:mid])
        r_nxt = find_next(preorder_idx, inorder[mid + 1:right])
        if l_nxt[0] != sys.maxsize and l_nxt[1] != sys.maxsize:
            node.left = TreeNode(l_nxt[1])
        if r_nxt[0] != sys.maxsize and r_nxt[1] != sys.maxsize:
            node.right = TreeNode(r_nxt[1])
        build(preorder_idx, inorder_idx, inorder, left, mid, node.left)
        build(preorder_idx, inorder_idx, inorder, mid + 1, right, node.right)


def find_next(preorder_idx: dict, sub: List[int]) -> []:
    ans = [sys.maxsize, sys.maxsize]
    for val in sub:
        if preorder_idx[val] < ans[0]:
            ans[0] = preorder_idx[val]
            ans[1] = val
    return ans


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        root = TreeNode(preorder[0])
        preorder_idx = dict(map(reversed, enumerate(preorder)))
        inorder_idx = dict(map(reversed, enumerate(inorder)))
        build(preorder_idx, inorder_idx, inorder, 0, len(inorder), root)
        return root
