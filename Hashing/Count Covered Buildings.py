Problem: Count Covered Buildings
Platform: LeetCode 
Time Complexity: O(m) 
Space Complexity: O(n) 

class Solution(object):
    def countCoveredBuildings(self, n, buildings):
        
        INF = 10**18
        
        minY = [INF] * (n + 1)
        maxY = [0] * (n + 1)
      
        minX = [INF] * (n + 1)
        maxX = [0] * (n + 1)

        for x, y in buildings:
            if y < minY[x]: minY[x] = y
            if y > maxY[x]: maxY[x] = y
            if x < minX[y]: minX[y] = x
            if x > maxX[y]: maxX[y] = x

        cnt = 0
        for x, y in buildings:
            if minX[y] < x < maxX[y] and minY[x] < y < maxY[x]:
                cnt += 1
        return cnt
