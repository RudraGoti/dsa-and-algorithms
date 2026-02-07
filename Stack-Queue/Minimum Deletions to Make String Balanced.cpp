Problem: Minimum Deletions to Make String Balanced
Platform: Leetcode
Time Complexity: O(n) 
Space Complexity: O(1) 


class Solution {
public:
    int minimumDeletions(string s) {
        int countB = 0;
        int deletions = 0;

        for (char c : s) {
            if (c == 'b') {
                countB++;
            } else {
                deletions = min(deletions + 1, countB);
            }
        }
        return deletions;
    }
};
