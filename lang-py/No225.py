"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/3/4 16:06:01
"""


class MyStack:

    def __init__(self):
        self.list = []

    def push(self, x: int) -> None:
        self.list.append(x)

    def pop(self) -> int:
        return self.list.pop()

    def top(self) -> int:
        return self.list[-1]

    def empty(self) -> bool:
        return not self.list
