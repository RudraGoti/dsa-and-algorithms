Problem: Minimum Time to fulfil all orders
Platform: GeeksforGeeks
Time Complexity: O(m log n)
Space Complexity: O(1)

class Solution {
  public:
    bool canMake(vector<int>& ranks, int n, int time) {
        long long total = 0;
        for (int r : ranks) {
            long long val = (long long)time * 2 / r;
            long long k = (sqrt(1 + 4 * val) - 1) / 2;
            total += k;
            if (total >= n) return true;
        }
        return total >= n;
    }

    int minTime(vector<int>& ranks, int n) {
        int low = 0;
        int high = *min_element(ranks.begin(), ranks.end()) * n * (n + 1) / 2;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
};
