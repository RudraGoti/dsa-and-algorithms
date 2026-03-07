Problem: Dice throw
Platform: GeeksforGeeks 
Time Complexity: O(n × x × m)
Space Complexity: O(n × x)


class Solution {
  public:
    int noOfWays(int m, int n, int x) {
        vector<vector<long long>> dp(n + 1, vector<long long>(x + 1, 0));
        
        dp[0][0] = 1;
        
        for(int dice = 1; dice <= n; dice++) {
            for(int sum = 1; sum <= x; sum++) {
                for(int face = 1; face <= m; face++) {
                    if(sum - face >= 0) {
                        dp[dice][sum] += dp[dice - 1][sum - face];
                    }
                }
            }
        }
        
        return dp[n][x];
    }
};
