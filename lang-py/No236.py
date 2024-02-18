"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/18 09:37:46
"""
from typing import List

from TreeNode import TreeNode


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(root: 'TreeNode', t: 'TreeNode') -> List['TreeNode']:
            if root is None:
                return []
            else:
                r1 = dfs(root.left, t)
                r2 = dfs(root.right, t)
                ans = r1 if r1 else r2
                if root.val == t.val or len(r1) > 0 or len(r2) > 0:
                    ans.append(root)
                return ans

        path1 = list(reversed(dfs(root, p)))
        path2 = list(reversed(dfs(root, q)))
        for i in range(min(len(path1), len(path2))):
            if path1[i].val != path2[i].val:
                return path1[i - 1]
            if path1[i] == p.val or path1[i] == q:
                return path1[i]
            elif path2[i] == p or path2[i] == q:
                return path2[i]
        return root
