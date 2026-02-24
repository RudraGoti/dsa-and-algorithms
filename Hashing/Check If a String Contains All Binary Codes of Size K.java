Problem: Check If a String Contains All Binary Codes of Size K
Platform: LeetCode
Time Complexity: O(N)
Space Complexity: O(2^k)


class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] seen = new boolean[need];

        int mask = need - 1;
        int num = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            num = ((num << 1) & mask) | (s.charAt(i) - '0');

            if (i >= k - 1 && !seen[num]) {
                seen[num] = true;
                count++;
                if (count == need) return true;
            }
        }
        return false;
    }
}
