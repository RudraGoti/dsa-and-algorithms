Problem: Kth smallest element in a Matrix
Platform: GeeksforGeeks
Time Complexity: O(n log(max-min))
Space Complexity: O(1) 

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n-1][n-1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(mat, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countLessEqual(int[][] mat, int mid) {
        int n = mat.length;
        int i = n - 1, j = 0;
        int count = 0;

        while (i >= 0 && j < n) {
            if (mat[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
