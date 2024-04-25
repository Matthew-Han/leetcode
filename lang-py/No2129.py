"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/3/11 09:40:27
"""


class Solution:
    def capitalizeTitle(self, title: str) -> str:
        return ' '.join(list(
            map(lambda x: x[0].upper() + x[1:] if len(x) > 2 else x, list(map(lambda x: x.lower(), title.split(" "))))))
