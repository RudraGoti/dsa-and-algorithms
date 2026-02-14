Problem: Roman to Integer
Platform: Leetcode 
Time Complexity: O(n)
Space Complexity: O(1) 


class Solution {
    public int romanToInt(String s) {
        int[] val = new int[128];
        val['I'] = 1;
        val['V'] = 5;
        val['X'] = 10;
        val['L'] = 50;
        val['C'] = 100;
        val['D'] = 500;
        val['M'] = 1000;

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = val[s.charAt(i)];

            if (curr < prev)
                total -= curr;
            else
                total += curr;

            prev = curr;
        }

        return total;
    }
}
