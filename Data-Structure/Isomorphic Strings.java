Problem: Isomorphic Strings
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(1)


class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if (m1[c1] == 0 && m2[c2] == 0) {
                m1[c1] = c2;
                m2[c2] = c1;
            } else if (m1[c1] != c2 || m2[c2] != c1) {
                return false;
            }
        }
        return true;
    }
}
