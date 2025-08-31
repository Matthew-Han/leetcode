"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/8/28 00:53:54
"""
from typing import List


class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        self.fuck_sort(grid, 0, 1, False)
        self.fuck_sort(grid, 1, 0, True)
        return grid

    def fuck_sort(self, grid: List[List[int]], sx: int, sy: int, reverse: bool = False) -> None:
        for i in range(sy, len(grid)):
            tmp = []
            x, y = i if reverse else 0, 0 if reverse else i
            while x < len(grid) and y < len(grid):
                tmp.append(grid[x][y])
                x += 1
                y += 1
            tmp.sort(reverse=reverse)
            x, y = i if reverse else 0, 0 if reverse else i
            for j in range(len(tmp)):
                grid[x][y] = tmp[j]
                x += 1
                y += 1
