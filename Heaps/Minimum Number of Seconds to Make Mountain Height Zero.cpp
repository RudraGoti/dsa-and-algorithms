Problem: Minimum Number of Seconds to Make Mountain Height Zero
Platform: Leetcode
Time Complexity: O(n log T)
Space Complexity: O(1)

class Solution {
public:
    long long minNumberOfSeconds(int mountainHeight, vector<int>& workerTimes) {
        long long l = 0, r = 1e18;

        while (l < r) {
            long long mid = (l + r) / 2;
            long long total = 0;

            for (long long w : workerTimes) {
                long long x = (sqrt(1 + (8.0 * mid) / w) - 1) / 2;
                total += x;
                if (total >= mountainHeight) break;
            }

            if (total >= mountainHeight)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
};
