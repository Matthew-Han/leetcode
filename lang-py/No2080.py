"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/8/15 02:07:54
"""
from collections import defaultdict
from typing import List


class RangeFreqQuery:

    def __init__(self, arr: List[int]):
        self.mem = defaultdict()
        for i in range(len(arr)):
            self.mem.setdefault(arr[i], []).append(i)

    def query(self, left: int, right: int, value: int) -> int:
        if value not in self.mem:
            return 0
        else:
            return self.searchX(left, self.mem[value]) \
                if left == right \
                else self.searchY(right, self.mem[value], True) - self.searchY(left, self.mem[value], False)

    def searchX(self, goal: int, arr: List[int]) -> int:
        l, r = 0, len(arr)
        while l <= r:
            mid = (l + r) >> 1
            if arr[mid] == goal:
                return 1
            elif arr[mid] < goal:
                l = mid + 1
            else:
                r = mid - 1
        return 0

    def searchY(self, goal: int, arr: List[int], direction: bool) -> int:
        l, r = 0, len(arr)
        hit = False
        while l < r:
            mid = (l + r) >> 1
            if arr[mid] < goal:
                l = mid + 1
            elif arr[mid] == goal:
                hit = True
                r = mid
            else:
                r = mid
        return l + (1 if hit and direction else 0)

