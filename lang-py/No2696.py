"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/10 09:27:14
"""


class Solution:
    def minLengthByReplace(self, s: str) -> int:
        curr = ''
        while (len(s) != len(curr)):
            curr = s
            s = s.replace('AB', '').replace('CD', '')
        return len(s)

    def minLength(self, s: str) -> int:
        stack = []
        for e in s:
            if len(stack) > 0:
                tmp = stack.pop()
                if (tmp == 'A' and e == 'B') or (tmp == 'C' and e == 'D'):
                    pass
                else:
                    stack.append(tmp)
                    stack.append(e)
            else:
                stack.append(e)
        return len(stack)
