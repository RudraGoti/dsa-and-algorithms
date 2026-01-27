Problem: Word Search
Platform: GeeksforGeeks
Time Complexity: O(n × m × 4^L) 
Space Complexity: O(L)


class Solution {
  public:
    int n, m;
    
    bool dfs(vector<vector<char>> &mat, string &word, int i, int j, int idx) {
    
        if (idx == word.size()) return true;
        

        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] != word[idx])
            return false;
        
    
        char temp = mat[i][j];
        mat[i][j] = '#';
        
        bool found = 
            dfs(mat, word, i + 1, j, idx + 1) ||
            dfs(mat, word, i - 1, j, idx + 1) ||
            dfs(mat, word, i, j + 1, idx + 1) ||
            dfs(mat, word, i, j - 1, idx + 1);
        

        mat[i][j] = temp;
        
        return found;
    }
    
    bool isWordExist(vector<vector<char>> &mat, string &word) {
        n = mat.size();
        m = mat[0].size();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(mat, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
};
