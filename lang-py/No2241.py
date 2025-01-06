"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2025/1/6 09:09:01
"""
from copy import deepcopy
from typing import List


class ATM:

    def __init__(self):
        self.val = [500, 200, 100, 50, 20]
        self.banknotesCount = [0, 0, 0, 0, 0]

    def deposit(self, banknotesCount: List[int]) -> None:
        banknotesCount.reverse()
        for i in range(len(banknotesCount)):
            self.banknotesCount[i] += banknotesCount[i]

    def withdraw(self, amount: int) -> List[int]:
        ans = [0, 0, 0, 0, 0]
        backup = deepcopy(self.banknotesCount)
        while amount > 0:
            flag = True
            for i in range(len(backup)):
                if backup[i] > 0 and amount >= self.val[i]:
                    flag = False
                    num = amount // self.val[i]
                    num = min(num, backup[i])
                    amount -= num * self.val[i]
                    backup[i] -= num
                    ans[i] += num
                    break
            if flag:
                return [-1]
        ans.reverse()
        self.banknotesCount = backup
        return ans
