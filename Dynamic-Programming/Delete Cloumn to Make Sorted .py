 // Problem: Delete Cloumn to Make Sorted 
 // Platform: Leetcode 
 // Time Complexity: O(m^2 * n) 
 // Space Complexity: O(m) 

class Solution(object):
    def minDeletionSize(self, strs):
        """
        :type strs: List[str]
        :rtype: int
        """
        n = len(strs)
        m = len(strs[0])
        
        
        dp = [1] * m
        max_keep = 1
        
        for j in range(m):
            for k in range(j):
                valid = True
                for r in range(n):
                    if strs[r][k] > strs[r][j]:
                        valid = False
                        break
                if valid:
                    dp[j] = max(dp[j], dp[k] + 1)
            
            max_keep = max(max_keep, dp[j])
        
        return m - max_keep
