"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/1/10 16:06:37
"""
from collections import defaultdict
from typing import List


class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.persons = persons
        self.times = times
        self.map = defaultdict(int)
        tmp = defaultdict(int)
        for i in range(len(persons)):
            person = persons[i]
            tmp[person] = tmp.get(person, 0) + 1
            mp = self.max_persons(tmp)
            if len(mp) > 1:
                for j in range(i, -1, -1):
                    if persons[j] in mp:
                        self.map[times[i]] = persons[j]
                        break
            else:
                self.map[times[i]] = mp.pop()

    def max_persons(self, tmp: defaultdict[int, int]) -> set[int]:
        sorted_persons = sorted(tmp.items(), key=lambda x: x[1], reverse=True)
        filter_persons = list(filter(lambda x: x[1] == sorted_persons[0][1], sorted_persons))
        return set(map(lambda x: x[0], filter_persons))

    def q(self, t: int) -> int:
        left = 0
        right = len(self.times) - 1
        while left < right:
            mid = left + (right - left + 1) // 2
            if self.times[mid] <= t:
                left = mid
            else:
                right = mid - 1
        return self.map.get(self.times[left])
