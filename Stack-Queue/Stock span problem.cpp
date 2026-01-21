Problem: Stock span problem
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(n)


class Solution {
  public:
    vector<int> calculateSpan(vector<int>& arr) {
        int n = arr.size();
        vector<int> span(n);
        stack<int> st;

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] <= arr[i]) {
                st.pop();
            }

            span[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }
        return span;
    }
};
