Problem: Last Moment Before All Ants Fall Out
Platform: GeeksforGeeks
Time Complexity: O(left.size() + right.size())
Space Complexity: O(1)

class Solution {
  public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) {
        int ans = 0;

        for (int x : left) ans = max(ans, x);
        for (int x : right) ans = max(ans, n - x);

        return ans;
    }
};
