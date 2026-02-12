Problem: Longest Balanced Substring I
Platform: LeetCode 
Time Complexity: O(n²) 
Space Complexity: O(1) 


class Solution(object):
    def longestBalanced(self, s):
        n = len(s)
        ans = 0

        for i in range(n):
            freq = [0] * 26
            for j in range(i, n):
                idx = ord(s[j]) - ord('a')
                freq[idx] += 1

                mn = float('inf')
                mx = 0
                for k in range(26):
                    if freq[k] > 0:
                        mn = min(mn, freq[k])
                        mx = max(mx, freq[k])

                if mn == mx:
                    ans = max(ans, j - i + 1)

        return ans
