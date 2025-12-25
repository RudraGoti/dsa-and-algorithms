// Problem: Maximum Happiness of Selected Children
// Platform: Leetcode
// Time Complexity: O(n log n)
// Space Complexity: O(1)

class Solution(object):
    def maximumHappinessSum(self, happiness, k):
        happiness.sort(reverse=True)
        total = 0

        for i in range(k):
            val = happiness[i] - i
            if val > 0:
                total += val

        return total
