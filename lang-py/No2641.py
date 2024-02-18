"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/7 09:37:02
"""
from collections import deque
from typing import Optional

from TreeNode import TreeNode


class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        q = deque[[TreeNode]]()
        q.append([root])
        while q:
            total = 0
            list = []
            for i in range(len(q)):
                pair: [TreeNode] = q.popleft()
                sub = []
                for curr in pair:
                    total += curr.val
                    sub.append(curr)
                    nxt = []
                    if curr.left:
                        nxt.append(curr.left)
                    if curr.right:
                        nxt.append(curr.right)
                    q.append(nxt)
                list.append(sub)
            for sub in list:
                diff = sum(node.val for node in sub)
                for e in sub:
                    e.val = total - diff
        return root
