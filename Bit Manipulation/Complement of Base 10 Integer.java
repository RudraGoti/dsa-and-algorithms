Problem: Complement of Base 10 Integer
Platform: LeetCode
Time Complexity: O(log N)
Space Complexity: O(1)


class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        
        int mask = 0;
        
        while (mask < n) {
            mask = (mask << 1) | 1;
        }
        
        return mask ^ n;
    }
}
