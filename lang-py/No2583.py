"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/23 12:40:36
"""
import queue
from collections import deque
from typing import Optional

from TreeNode import TreeNode


class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        q = deque()
        q.append(root)
        top_k = queue.PriorityQueue(k)
        while q:
            limit = len(q)
            sum = 0
            for _ in range(limit):
                curr = q.popleft()
                sum += curr.val
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if not top_k.full():
                top_k.put(sum)
            else:
                tmp = top_k.get()
                top_k.put(max(tmp, sum))
        return -1 if k > top_k.qsize() else top_k.get()
