Problem: Last Day Where You Can Still Cross
Platform: Leetcode
Time Complexity: O(row × col)
Space Complexity: O(log(row × col))


class Solution {
public:
    int row, col;
    vector<vector<int>> dirs{{1,0},{-1,0},{0,1},{0,-1}};
    
    bool canCross(int day, vector<vector<int>>& cells) {
        vector<vector<int>> grid(row, vector<int>(col, 0));
        
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        
        queue<pair<int,int>> q;
        vector<vector<int>> vis(row, vector<int>(col, 0));
        
        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                q.push({0, c});
                vis[0][c] = 1;
            }
        }
        
        while (!q.empty()) {
            auto [r, c] = q.front(); q.pop();
            if (r == row - 1) return true;
            
            for (auto &d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                    grid[nr][nc] == 0 && !vis[nr][nc]) {
                    vis[nr][nc] = 1;
                    q.push({nr, nc});
                }
            }
        }
        
        return false;
    }
    
    int latestDayToCross(int r, int c, vector<vector<int>>& cells) {
        row = r;
        col = c;
        
        int low = 1, high = cells.size(), ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canCross(mid, cells)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
};
