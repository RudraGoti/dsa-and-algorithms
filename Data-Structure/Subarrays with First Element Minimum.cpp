Problem: Subarrays with First Element Minimum
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(n)


class Solution {
  public:
    int countSubarrays(vector<int> &arr) {
        int n = arr.size();
        stack<int> st;
        long long ans = 0;

        for(int i = n - 1; i >= 0; i--) {
            while(!st.empty() && arr[st.top()] >= arr[i]) {
                st.pop();
            }

            int next = st.empty() ? n : st.top();
            ans += (next - i);

            st.push(i);
        }

        return ans;
    }
};
