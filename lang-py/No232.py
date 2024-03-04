"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/3/4 15:52:19
"""


class MyQueue:

    def __init__(self):
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        self.stack.remove(ans := self.stack[0])
        return ans

    def peek(self) -> int:
        return self.stack[0]

    def empty(self) -> bool:
        return len(self.stack) == 0
