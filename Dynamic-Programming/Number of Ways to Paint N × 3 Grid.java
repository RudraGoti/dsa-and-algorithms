Problem: Number of Ways to Paint N × 3 Grid
Platform: Leetcode 
Time Complexity: O(n) 
Space Complexity: O(1) 

class Solution {
    private static final int MOD = 1_000_000_007;

    public int numOfWays(int n) {
        long a = 6; 
        long b = 6; 

        for (int i = 2; i <= n; i++) {
            long newA = (2 * a + 2 * b) % MOD;
            long newB = (2 * a + 3 * b) % MOD;
            a = newA;
            b = newB;
        }

        return (int) ((a + b) % MOD);
    }
}
