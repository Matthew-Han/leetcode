"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/19 10:44:18
"""
from collections import Counter


class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        sorted_dict = sorted(Counter(s).items(), key=lambda t: t[0])
        ans = []
        while True:
            if len(sorted_dict) == 0:
                break
            last = ans[-1] if len(ans) > 0 else ''
            max_char = sorted_dict.pop()
            if not max_char[0] == last:
                cnt = min(repeatLimit, max_char[1])
                if max_char[1] - cnt > 0:
                    sorted_dict.append((max_char[0], max_char[1] - cnt))
                for e in range(cnt):
                    ans.append(max_char[0])
            else:
                if len(sorted_dict) == 0:
                    break
                sec_char = sorted_dict.pop()
                cnt = min(1, sec_char[1])
                if sec_char[1] - cnt > 0:
                    sorted_dict.append((sec_char[0], sec_char[1] - cnt))
                for e in range(cnt):
                    ans.append(sec_char[0])
                sorted_dict.append(max_char)

        return ''.join(ans)
