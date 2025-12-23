// Problem: Two Best Non-overlaping Events
// Platform: Leetcode 
// Time Complexity: O(n log n) 
// Space Complexity: O(n) 

class Solution(object):
    def maxTwoEvents(self, events):
        events.sort()
        n = len(events)

        maxFrom = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            maxFrom[i] = max(maxFrom[i + 1], events[i][2])

        ans = 0
        for i in range(n):
            ans = max(ans, events[i][2])
            l, r = i + 1, n - 1
            idx = n
            while l <= r:
                m = (l + r) // 2
                if events[m][0] >= events[i][1] + 1:
                    idx = m
                    r = m - 1
                else:
                    l = m + 1
            ans = max(ans, events[i][2] + maxFrom[idx])

        return ans
