"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/11 09:38:27
"""


class Solution:
    def addMinimum(self, word: str) -> int:
        ans = 0
        last = ''
        for e in word:
            if last == '':
                ans += 0 if e == 'a' else 1 if e == 'b' else 2
            else:
                if last == 'a':
                    ans += 2 if e == 'a' else 0 if e == 'b' else 1
                elif last == 'b':
                    ans += 1 if e == 'a' else 2 if e == 'b' else 0
                else:
                    ans += 0 if e == 'a' else 1 if e == 'b' else 2
            last = e
        return ans + 2 if last == 'a' else 1 if last == 'b' else 0
