Problem: Binary Number with Alternating Bits
Platform: LeetCode
Time Complexity: O(1)
Space Complexity: O(1)


class Solution(object):
    def hasAlternatingBits(self, n):
        x = n ^ (n >> 1)
        return (x & (x + 1)) == 0
