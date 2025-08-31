"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/9/1 03:04:51
"""
from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        def checkRow() -> bool:
            for i in range(9):
                vis = set()
                for j in range(9):
                    if board[i][j].isdigit() and board[i][j] in vis:
                        return False
                    vis.add(board[i][j])
            return True

        def checkCol() -> bool:
            for i in range(9):
                vis = set()
                for j in range(9):
                    if board[j][i].isdigit() and board[j][i] in vis:
                        return False
                    vis.add(board[j][i])
            return True

        def checkMatrix() -> bool:
            def dfs(x: int, y: int) -> bool:
                if x < 9 and y < 9:
                    vis = set()
                    for i in range(x, x + 3):
                        for j in range(y, y + 3):
                            if board[i][j].isdigit() and board[i][j] in vis:
                                return False
                            else:
                                vis.add(board[i][j])
                    return dfs(x + 3, y) and dfs(x, y + 3) and dfs(x + 3, y + 3)
                else:
                    return True
            return dfs(0, 0)

        return checkRow() and checkCol() and checkMatrix()
