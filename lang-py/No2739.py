"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/4/25 下午5:11:28
"""


class Solution:
    def distanceTraveled(self, mainTank: int, additionalTank: int) -> int:
        ans = 0
        cnt = 0
        while mainTank > 0:
            cnt += 1
            ans += 1
            mainTank -= 1
            if cnt == 5:
                cnt = 0
                mainTank += min(1, additionalTank)
                additionalTank -= min(additionalTank, 1)
        return ans * 10