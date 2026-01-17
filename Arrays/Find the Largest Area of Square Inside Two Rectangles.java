Problem: Find the Largest Area of Square Inside Two Rectangles
Platform: LeetCode 
Time Complexity: O(n^2)
Space Complexity: O(1)


class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long w = Math.min(topRight[i][0], topRight[j][0]) 
                       - Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long h = Math.min(topRight[i][1], topRight[j][1]) 
                       - Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                if (w > 0 && h > 0) {
                    long side = Math.min(w, h);
                    ans = Math.max(ans, side * side);
                }
            }
        }
        return ans;
    }
}
