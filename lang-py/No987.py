"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:38:59
"""
from collections import defaultdict, deque
from typing import Optional, List

from TreeNode import TreeNode


class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        mem = defaultdict[int, List[List[int]]]()
        stack = deque[[int, int, Optional[TreeNode]]]()
        stack.append([0, 0, root])
        while stack:
            pair = stack.pop()
            v = mem.get(pair[0], [])
            v.append([pair[1], pair[2].val])
            mem[pair[0]] = v
            if pair[2].left:
                stack.append([pair[0] - 1, pair[1] + 1, pair[2].left])
            if pair[2].right:
                stack.append([pair[0] + 1, pair[1] + 1, pair[2].right])
        val = list(map(lambda x: x[1], list(sorted(mem.items(), key=lambda x: x[0]))))
        ans = []
        for sub in list(sorted(sub, key=lambda x: (x[0], x[1])) for sub in val):
            ans.append(list(map(lambda x: x[1], list(e for e in sub))))
        return ans
