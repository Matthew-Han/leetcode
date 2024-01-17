class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        ans = str(self.val) + ' --> '
        while self.next:
            ans += str(self.next.val)
            ans += " --> "
            self.next = self.next.next
        return ans
