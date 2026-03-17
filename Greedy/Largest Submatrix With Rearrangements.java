Problem: Largest Submatrix With Rearrangements
Platform: LeetCode
Time Complexity: O(m×nlogn)
Space Complexity: O(n)


class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == 1 ? height[j] + 1 : 0;
            }

            int[] temp = height.clone();
            java.util.Arrays.sort(temp);

            for (int j = 0; j < n; j++) {
                int h = temp[n - 1 - j];
                maxArea = Math.max(maxArea, h * (j + 1));
            }
        }
        return maxArea;
    }
}
