Problem: Construct the Minimum Bitwise Array I
Platform: LeetCode 
Time Complexity: O(n) 
Space Complexity: O(1)


class Solution(object):
    def minBitwiseArray(self, nums):
        ans = []
        for x in nums:
            if x == 2:
                ans.append(-1)
            else:
                ans.append(x - (( (x ^ (x + 1)) + 1) >> 2))
        return ans
