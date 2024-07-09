"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/7/9 上午9:12:33
"""


class Solution:
    def smallestString(self, s: str) -> str:
        ans = ''
        l = 0
        for i in range(len(s)):
            l = i
            if i != len(s) - 1 and s[i] == 'a':
                l += 1
                ans += 'a'
            elif i == len(s) - 1 and s[i] == 'a':
                l += 1
                ans += 'z'
            else:
                break
        for i in range(l, len(s)):
            if s[i] != 'a':
                ans += chr(ord(s[i]) - 1)
            else:
                ans += s[i:]
                break
        return ans
