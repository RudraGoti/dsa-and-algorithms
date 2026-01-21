Problem: Construct the Minimum Bitwise Array II
Platform: LeetCode 
Time Complexity: O(n)
Space Complexity: O(1)


class Solution(object):
    def minBitwiseArray(self, nums):
        ans = []
        for n in nums:
            if n % 2 == 0:
                ans.append(-1)
            else:
                t = (n + 1) & -(n + 1)
                ans.append(n - (t >> 1))
        return ans
