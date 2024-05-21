"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/4/28 上午10:32:01
"""

from collections import defaultdict


class SnapshotArray:

    def __init__(self, length: int):
        self.cache = defaultdict[int, defaultdict[int, int]]()
        for i in range(length):
            self.cache[i] = defaultdict(int, [(0, 0)])
        self.version = 0

    def set(self, index: int, val: int) -> None:
        map = self.cache.setdefault(index, defaultdict(int))
        map[self.version] = val

    def snap(self) -> int:
        self.version += 1
        return self.version - 1

    def get(self, index: int, snap_id: int) -> int:
        map: defaultdict[int, int] = self.cache.setdefault(index, defaultdict(int, [(snap_id, 0)]))
        if map.get(snap_id) is None:
            t = list(map.keys())
            l, r = 0, len(t) - 1
            while l < r:
                mid = (l + r + 1) >> 1
                if t[mid] <= snap_id:
                    l = mid
                else:
                    r = mid - 1
            return map[t[l]]
        else:
            return map.get(snap_id)