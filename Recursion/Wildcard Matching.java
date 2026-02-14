Problem: Wildcard Matching
Platform: Leetcode 
Time Complexity: O(n × m)
Space Complexity: O(m) 


class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        for (int j = 1; j <= m; j++)
            if (p.charAt(j - 1) == '*')
                dp[j] = dp[j - 1];

        for (int i = 1; i <= n; i++) {
            boolean prev = dp[0];
            dp[0] = false;

            for (int j = 1; j <= m; j++) {
                boolean temp = dp[j];

                if (p.charAt(j - 1) == '*')
                    dp[j] = dp[j] || dp[j - 1];
                else
                    dp[j] = prev && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));

                prev = temp;
            }
        }

        return dp[m];
    }
}
