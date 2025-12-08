// Problem: Number of distinct subsequences
// Platform: GeeksforGeeks
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    static final int MOD = 1000000007;

    public int distinctSubseq(String s) {
        int n = s.length();
        long[] last = new long[26];   
        long tot = 1;                 

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            long newTot = (tot * 2) % MOD;   
            newTot = (newTot - last[c] + MOD) % MOD;  
            last[c] = tot;                    
            tot = newTot;
        }

        return (int)tot;
    }
}
