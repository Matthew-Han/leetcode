"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/2/4 14:49:31
"""
from typing import List
from queue import PriorityQueue


class Solution:
    def stoneGameVI(self, aliceValues: List[int], bobValues: List[int]) -> int:
        n = len(aliceValues)
        sum = list([-(aliceValues[i] + bobValues[i]), i] for i in range(n))
        pq = PriorityQueue(n)
        for e in sum:
            pq.put(e)
        alice, bob, flag = 0, 0, False
        while not pq.empty():
            alice += 0 if flag else aliceValues[pq.get()[1]]
            bob += 0 if not flag else bobValues[pq.get()[1]]
            flag = not flag
        return 0 if alice == bob else 1 if alice > bob else -1
