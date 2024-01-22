"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/17 19:17:46
"""
from collections import Counter
from typing import List


class Solution:
    def maximumNumberOfStringPairs(self, words: List[str]) -> int:
        return len(list(filter(lambda x: x[1] == 2, Counter(map(lambda x: ''.join(sorted(x)), words)).items())))
