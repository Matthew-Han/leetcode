"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/26 10:29:18
"""
from typing import Optional, List
from TreeNode import TreeNode


def find_left(root: Optional[TreeNode], target: int, res: int) -> int:
    if not root:
        return res
    else:
        if root.val <= target:
            return find_left(root.right, target, root.val)
        else:
            return find_left(root.left, target, res)


def find_right(root: Optional[TreeNode], target: int, res: int) -> int:
    if not root:
        return res
    else:
        if root.val >= target:
            return find_right(root.left, target, root.val)
        else:
            return find_right(root.right, target, res)


class Solution:
    # 超时了
    def closestNodes_old(self, root: Optional[TreeNode], queries: List[int]) -> List[List[int]]:
        res = []
        for query in queries:
            res.append([find_left(root, query, -1), find_right(root, query, -1)])
        return res

    def closestNodes(self, root: Optional[TreeNode], queries: List[int]) -> List[List[int]]:
        q, list, ans = [], [], []
        while q or root:
            if root:
                q.append(root)
                root = root.left
            else:
                root = q.pop()
                list.append(root.val)
                root = root.right
        for query in queries:
            l = 0
            r = len(list) - 1
            sub = [-1] * 2
            while l < r:
                # 防止死循环, 向右移动!
                mid = l + r + 1 >> 1
                if list[mid] <= query:
                    l = mid
                else:
                    r = mid - 1
            sub[0] = list[l] if list[l] <= query else -1
            l = 0
            r = len(list) - 1
            while l < r:
                # 防止死循环, 向左移动!
                mid = (l + r - 1) >> 1
                if list[mid] >= query:
                    r = mid
                else:
                    l = mid + 1
            sub[1] = list[r] if list[r] >= query else -1
            ans.append(sub)
        return ans
