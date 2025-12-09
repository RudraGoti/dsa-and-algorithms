// Problem: Longest Substring Without Repeating Characters
// Platform: LeetCode 
// Time Complexity: O(n) 
// Space Complexity: O(1) 

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        seen = {}
        left = 0
        res = 0

        for right in range(len(s)):
            if s[right] in seen and seen[s[right]] >= left:
                left = seen[s[right]] + 1
            
            seen[s[right]] = right
            res = max(res, right - left + 1)

        return res
