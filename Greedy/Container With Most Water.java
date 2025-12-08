// Problem: Container With Most Water
// Platform: LeetCode
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxArea(int[] h) {
        int n = h.length;
        int l = 0, r = n - 1;
        int ans = 0;

        while (l < r) {
            int area = Math.min(h[l], h[r]) * (r - l);
            ans = Math.max(ans, area);

            if (h[l] < h[r]) l++;
            else r--;
        }

        return ans;
    }
}
