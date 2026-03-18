Problem: Count Submatrices with Top-Left Element and Sum Less Than k
Platform: LeetCode 
Time Complexity: O(m × n)
Space Complexity: O(n)

class Solution {
public:
    int countSubmatrices(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        
        vector<long long> colSum(n, 0);
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            long long currSum = 0;
            for (int j = 0; j < n; j++) {
                colSum[j] += grid[i][j];
                currSum += colSum[j];
                if (currSum <= k) count++;
            }
        }
        
        return count;
    }
};
