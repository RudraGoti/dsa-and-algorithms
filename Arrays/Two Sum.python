// Problem: Two Sum
// Platform: LeetCode
// Time Complexity: O(n), O(1) average
// Space Complexity: O(n)

class Solution:
    def twoSum(self, nums, target):
        mp = {}   

        for i, v in enumerate(nums):
            need = target - v

            if need in mp:
                return [mp[need], i]

            mp[v] = i

        return []
