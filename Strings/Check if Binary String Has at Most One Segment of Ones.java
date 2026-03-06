Problem: Check if Binary String Has at Most One Segment of Ones
Platform: LeetCode 
Time Complexity: O(n) 
Space Complexity: O(1) 


class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
