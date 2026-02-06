Problem: Minimum Removals to Balance Array
Platform: Leetcode
Time Complexity: O(n log n)
Space Complexity: O(1) 


class Solution {
public:
    int minRemoval(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int maxLen = 1;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && (long long)nums[j] <= (long long)nums[i] * k) {
                j++;
            }
            maxLen = max(maxLen, j - i);
        }
        return n - maxLen;
    }
};
