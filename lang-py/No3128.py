"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/8/2 下午3:50:27
"""
from typing import List


class Solution:

    def mem(self, grid: List[List[int]]) -> None:
        row0 = [[0] * len(grid[0]) for _ in range(len(grid))]
        row1 = [[0] * len(grid[0]) for _ in range(len(grid))]
        col0 = [[0] * len(grid[0]) for _ in range(len(grid))]
        col1 = [[0] * len(grid[0]) for _ in range(len(grid))]

        for i in range(len(grid)):
            for j in range(1, len(grid[i])):
                row0[i][j] += grid[i][j - 1] + row0[i][j - 1]

        for i in range(len(grid)):
            for j in range(len(grid[i]) - 1, 0, -1):
                row1[i][j - 1] = grid[i][j] + row1[i][j]

        for j in range(len(grid[0])):
            for i in range(1, len(grid)):
                col0[i][j] = grid[i - 1][j] + col0[i - 1][j]

        for j in range(len(grid[0])):
            for i in range(len(grid) - 1, 0, -1):
                col1[i - 1][j] = grid[i][j] + col1[i][j]

        self.row0 = row0
        self.row1 = row1
        self.col0 = col0
        self.col1 = col1

    def numberOfRightTriangles(self, grid: List[List[int]]) -> int:
        ans = 0
        self.mem(grid)
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    ans += (self.row0[i][j] * self.col0[i][j] + self.row0[i][j] * self.col1[i][j]
                            + self.row1[i][j] * self.col0[i][j] + self.row1[i][j] * self.col1[i][j])

        return ans

