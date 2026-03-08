Problem: Pythagorean Triplet
Platform: GeeksforGeeks
Time Complexity: O(n²)
Space Complexity: O(n)


class Solution {
  public:
    bool pythagoreanTriplet(vector<int>& arr) {
        unordered_set<int> s;
        
        for(int x : arr)
            s.insert(x * x);
        
        int n = arr.size();
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int sum = arr[i]*arr[i] + arr[j]*arr[j];
                if(s.count(sum)) return true;
            }
        }
        
        return false;
    }
};
