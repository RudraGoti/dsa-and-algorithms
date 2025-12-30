Problem: Magic Squares In Grid
Platform: LeetCode
Time Complexity: O(R × C)
Space Complexity: O(1)

class Solution {
public:
    bool isMagic(vector<vector<int>>& g, int r, int c) {

        if (g[r+1][c+1] != 5) return false;

        bool seen[10] = {false};
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int v = g[i][j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        }

        return
            g[r][c] + g[r][c+1] + g[r][c+2] == 15 &&
            g[r+1][c] + g[r+1][c+1] + g[r+1][c+2] == 15 &&
            g[r+2][c] + g[r+2][c+1] + g[r+2][c+2] == 15 &&

            g[r][c] + g[r+1][c] + g[r+2][c] == 15 &&
            g[r][c+1] + g[r+1][c+1] + g[r+2][c+1] == 15 &&
            g[r][c+2] + g[r+1][c+2] + g[r+2][c+2] == 15 &&

            g[r][c] + g[r+1][c+1] + g[r+2][c+2] == 15 &&
            g[r][c+2] + g[r+1][c+1] + g[r+2][c] == 15;
    }

    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        int count = 0;

        if (rows < 3 || cols < 3) return 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
};
