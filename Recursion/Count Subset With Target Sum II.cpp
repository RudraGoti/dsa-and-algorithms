Problem: Count Subset With Target Sum II
Platform: GeeksforGeeks
Time Complexity: O(2^(n/2))
Space Complexity: O(2^(n/2))


class Solution {
public:
    int countSubset(vector<int>& arr, int k) {
        int n = arr.size();
        int mid = n / 2;

        vector<int> left(arr.begin(), arr.begin() + mid);
        vector<int> right(arr.begin() + mid, arr.end());

        vector<long long> L, R;

        int n1 = left.size(), n2 = right.size();

        for (int mask = 0; mask < (1 << n1); mask++) {
            long long sum = 0;
            for (int i = 0; i < n1; i++)
                if (mask & (1 << i)) sum += left[i];
            L.push_back(sum);
        }

        for (int mask = 0; mask < (1 << n2); mask++) {
            long long sum = 0;
            for (int i = 0; i < n2; i++)
                if (mask & (1 << i)) sum += right[i];
            R.push_back(sum);
        }

        sort(R.begin(), R.end());

        int ans = 0;
        for (long long x : L) {
            long long need = k - x;
            ans += upper_bound(R.begin(), R.end(), need) -
                   lower_bound(R.begin(), R.end(), need);
        }

        return ans;
    }
};
