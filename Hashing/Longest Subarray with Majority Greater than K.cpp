Problem: Longest Subarray with Majority Greater than K
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(n)


class Solution {
  public:
    int longestSubarray(vector<int> &arr, int k) {
        
        unordered_map<int,int> mp;
        int prefix = 0;
        int ans = 0;

        for(int i = 0; i < arr.size(); i++) {

            if(arr[i] > k)
                prefix += 1;
            else
                prefix -= 1;

            if(prefix > 0)
                ans = i + 1;

            if(mp.find(prefix) == mp.end())
                mp[prefix] = i;

            if(mp.find(prefix - 1) != mp.end())
                ans = max(ans, i - mp[prefix - 1]);
        }

        return ans;
    }
};
