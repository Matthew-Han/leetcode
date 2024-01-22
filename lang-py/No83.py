"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/19 10:43:52
"""
from typing import Optional
import ListNode


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        tmp = head
        while tmp.next:
            if tmp.val == tmp.next.val:
                tmp.next = tmp.next.next
            else:
                tmp = tmp.next

        return head
