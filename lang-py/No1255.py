"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/12 14:44:05
"""
from collections import defaultdict, Counter
from typing import List


class Solution:

    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        self.ans = 0
        ws = self.words_score(words, score)
        lu = self.letter_used(letters)
        self.dfs(words, 0, lu, ws, 0)
        return self.ans

    def dfs(self, words: List[str], idx: int, lu: defaultdict[str, int], ws: defaultdict[str, int], sum: int):
        for i in range(idx, len(words)):
            if self.check(words[i], lu):
                # 消费
                for k, v in defaultdict(int, Counter(words[i]).items()).items():
                    lu[k] = lu.get(k) - v
                self.dfs(words, i + 1, lu, ws, sum + ws[words[i]])
                # 回溯
                for k, v in defaultdict(int, Counter(words[i]).items()).items():
                    lu[k] += v
            else:
                self.dfs(words, i + 1, lu, ws, sum)
        self.ans = max(self.ans, sum)

    @staticmethod
    def check(word: str, lu: defaultdict[str, int]) -> bool:
        tmp = Counter(word).items()
        for k, v in defaultdict(int, tmp).items():
            if lu.get(k, 0) < v:
                return False
        return True

    @staticmethod
    def words_score(words: List[str], score: List[int]) -> defaultdict[str, int]:
        ans = defaultdict(int)
        for word in words:
            ans[word] = sum(score[ord(c) - ord('a')] for c in word)
        return ans

    @staticmethod
    def letter_used(letters: List[str]) -> defaultdict[str, int]:
        return defaultdict(int, Counter(letters).items())
