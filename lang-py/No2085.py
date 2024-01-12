"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/12 09:10:54
"""
from typing import List
from collections import Counter, defaultdict


class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        return len(set(defaultdict(str, filter(lambda x: x[1] == 1, Counter(words1).items())).keys()).intersection(
            set(defaultdict(str, filter(lambda x: x[1] == 1, Counter(words2).items())).keys())))
