Problem: Minimum Operations to Equalize Binary String
Platform: Leetcode
Time Complexity: O(n log n)
Space Complexity: O(n)


class Solution {
public:
    int minOperations(string s, int k) {
        int n = s.length();
        int initial_zeros = 0;
        for (char c : s) if (c == '0') initial_zeros++;

        if (initial_zeros == 0) return 0;

        vector<int> dist(n + 1, -1);
        queue<int> q;

        dist[initial_zeros] = 0;
        q.push(initial_zeros);

        vector<int> next_to_visit_even, next_to_visit_odd;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) next_to_visit_even.push_back(i);
            else next_to_visit_odd.push_back(i);
        }

        auto it_even = next_to_visit_even.begin();
        auto it_odd = next_to_visit_odd.begin();

        while (!q.empty()) {
            int curr = q.front();
            q.pop();

            int x_min = max(0, k - n + curr);
            int x_max = min(curr, k);

            int next_min = curr + k - 2 * x_max;
            int next_max = curr + k - 2 * x_min;

            auto& vec = (next_min % 2 == 0) ? next_to_visit_even : next_to_visit_odd;
            auto it = lower_bound(vec.begin(), vec.end(), next_min);
            
            while (it != vec.end() && *it <= next_max) {
                if (dist[*it] == -1) {
                    dist[*it] = dist[curr] + 1;
                    if (*it == 0) return dist[*it];
                    q.push(*it);
                    it = vec.erase(it);
                } else {
                    ++it;
                }
            }
        }

        return dist[0];
    }
};
