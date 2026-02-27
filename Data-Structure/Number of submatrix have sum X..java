Problem: Number of submatrix have sum X
Platform: GeeksforGeeks
Time Complexity: O(nm min(n,m))
Space Complexity: O(n*m)


class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pre = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                        + pre[i - 1][j]
                        + pre[i][j - 1]
                        - pre[i - 1][j - 1];
            }
        }

        int count = 0;
        int maxSize = Math.min(n, m);

        for (int size = 1; size <= maxSize; size++) {
            for (int i = 1; i + size - 1 <= n; i++) {
                for (int j = 1; j + size - 1 <= m; j++) {

                    int r = i + size - 1;
                    int c = j + size - 1;

                    int sum = pre[r][c]
                            - pre[i - 1][c]
                            - pre[r][j - 1]
                            + pre[i - 1][j - 1];

                    if (sum == x)
                        count++;
                }
            }
        }

        return count;
    }
}
