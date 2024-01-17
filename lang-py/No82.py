from collections import defaultdict
from typing import Optional

from ListNode import ListNode


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        tmp = ListNode()
        ans = tmp
        list = []
        map = defaultdict(int)
        while head:
            list.append(head)
            map[head.val] = map.get(head.val, 0) + 1
            head = head.next

        for e in list:
            if map[e.val] == 1:
                tmp.next = e
                tmp = tmp.next
        tmp.next = None
        return ans.next


if __name__ == '__main__':
    print(ListNode(2, ListNode(1, ListNode(1, ListNode(16, ListNode(3, ListNode(3)))))))
