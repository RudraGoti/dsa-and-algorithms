 // Problem: Two Sum 
 // Platform: LeetCode 
 // Time Complexity: O(n) 
 // Space Complexity: O(n) 

class Solution {
    public int c(int[] a, int k) {
        long t = 0;
        for (int x : a) t += x;
        int r = (int)(k % t);
        for (int i = 0; i < a.length; i++) {
            if (r < a[i]) return i;
            r -= a[i];
        }
        return 0;
    }
}
