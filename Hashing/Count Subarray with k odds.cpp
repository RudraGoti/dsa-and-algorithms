Problem: Count Subarray with k odds
Platform: GeeksforGeeks
Time Complexity: O(n) 
Space Complexity: O(1) 

class Solution {
public:
    int atMostK(vector<int>& arr, int k) {
        int left = 0, oddCount = 0, res = 0;
        for (int right = 0; right < arr.size(); right++) {
            if (arr[right] % 2) oddCount++;
            while (oddCount > k) {
                if (arr[left] % 2) oddCount--;
                left++;
            }
            res += (right - left + 1);
        }
        return res;
    }

    int countSubarrays(vector<int>& arr, int k) {
        return atMostK(arr, k) - atMostK(arr, k - 1);
    }
};
