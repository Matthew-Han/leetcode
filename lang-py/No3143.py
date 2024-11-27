"""
  author <a href="https://github.com/Matthew-Han">Matthew Han</a>
  since 2024/8/9 下午5:19:28
"""

from typing import List


class Solution:
    def maxPointsInsideSquare(self, points: List[List[int]], s: str) -> int:
        new_points = []
        vis = set()
        ans = 0
        points = list(map(lambda sublist: list(map(abs, sublist)), points))
        for i in range(len(points)):
            t = [s[i], points[i][0], points[i][1], max(points[i][0], points[i][1])]
            new_points.append(t)
        new_points.sort(key=lambda t: t[3])
        for i in range(len(new_points)):
            if new_points[i][0] in vis:
                return ans
            else:
                vis.add(new_points[i][0])
                new_vis = set(new_points[i][0])
                for j in range(i + 1, len(new_points)):
                    if new_points[j][3] == new_points[i][3]:
                        if new_points[j][0] in new_vis or new_points[j][0] in vis:
                            return i
                        else:
                            new_vis.add(new_points[j][0])
                    else:
                        break
                ans += 1
        return ans
