 // Problem: Sum of Digits of String After Convert
 // Platform: LeetCode 
 // Time Complexity: O(n + k)
 // Space Complexity: O(n) 

class Solution {
    public int g(String s, int k) {
        StringBuilder b = new StringBuilder();
        int s1 = 0, n = s.length();
        for (int i = 0; i < n; i++) b.append(s.charAt(i) - 'a' + 1);
        for (int i = 0; i < b.length(); i++) s1 += b.charAt(i) - '0';
        k--;
        while (k > 0) {
            int x = s1; 
            s1 = 0;
            while (x > 0) {
                s1 += x % 10;
                x /= 10;
            }
            k--;
        }
        return s1;
    }
}
