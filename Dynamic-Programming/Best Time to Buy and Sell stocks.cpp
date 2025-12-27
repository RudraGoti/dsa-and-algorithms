// Problem: Best Time to Buy and Sell stocks.cpp
// Platform: Leetcode 
// Time Complexity: O(k * n) 
// Space Complexity: O(k * n) 

class Solution {
public:
    long long maximumProfit(vector<int>& prices, int k) {
        int n = prices.size();
        vector<vector<long long>> dp(k + 1, vector<long long>(n, 0));

        for (int t = 1; t <= k; t++) {
            long long bestLong = -prices[0];
            long long bestShort = prices[0];

            for (int i = 1; i < n; i++) {
                dp[t][i] = max({
                    dp[t][i - 1],
                    prices[i] + bestLong,
                    -prices[i] + bestShort
                });

                bestLong = max(bestLong, dp[t - 1][i - 1] - prices[i]);
                bestShort = max(bestShort, dp[t - 1][i - 1] + prices[i]);
            }
        }
        return dp[k][n - 1];
    }
};
