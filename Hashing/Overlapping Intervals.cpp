 // Problem: Array Duplicate
 // Platform: GeeksgorGeeks 
 // Time Complexity: O(n log n) 
 // Space Complexity: O(n)

class Solution {
  public:
    vector<vector<int>> mergeOverlap(vector<vector<int>>& arr) {
        
        sort(arr.begin(), arr.end());
        vector<vector<int>> res;
        for (auto &i : arr) {
            if (res.empty() || res.back()[1] < i[0])
                res.push_back(i);
            else
                res.back()[1] = max(res.back()[1], i[1]);
        }
        return res;
        
    }
};
