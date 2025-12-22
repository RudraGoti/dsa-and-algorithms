// Problem: Row with max 1's.cpp  
 // Platform: GeeksgorGeeks 
 // Time Complexity: O(n log m) 
 // Space Complexity: O(1) 

class Solution {
  public:
    int rowWithMax1s(vector<vector<int>> &arr) {
        int n = arr.size();
        int m = arr[0].size();
        
        int maxOnes = 0;
        int rowIndex = -1;

        for (int i = 0; i < n; i++) {
            int low = 0, high = m - 1;
            int firstOne = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[i][mid] == 1) {
                    firstOne = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (firstOne != -1) {
                int onesCount = m - firstOne;
                if (onesCount > maxOnes) {
                    maxOnes = onesCount;
                    rowIndex = i;
                }
            }
        }

        return rowIndex;
    }
};
