Problem: Counts Mentions Per User
Platform: Leetcode
Time Complexity: O(E.N)
Space Complexity: O(n) 

class Solution {
public:
    vector<int> countMentions(int n, vector<vector<string>>& events) {
        vector<int> ans(n), on(n,1), back(n,-1);

        sort(events.begin(), events.end(), [&](auto &a, auto &b){
            int ta = stoi(a[1]), tb = stoi(b[1]);
            if (ta != tb) return ta < tb;
            if (a[0] == "OFFLINE" && b[0] == "MESSAGE") return true;
            if (a[0] == "MESSAGE" && b[0] == "OFFLINE") return false;
            return false; 
        });

        for (auto &e : events) {
            int t = stoi(e[1]);

            for (int i = 0; i < n; i++)
                if (!on[i] && back[i] <= t) on[i] = 1;

            if (e[0] == "OFFLINE") {
                int id = stoi(e[2]);
                on[id] = 0;
                back[id] = t + 60;
            } else {
                string s = e[2];
                if (s == "ALL") {
                    for (int i = 0; i < n; i++) ans[i]++;
                } else if (s == "HERE") {
                    for (int i = 0; i < n; i++) if (on[i]) ans[i]++;
                } else {
                    stringstream ss(s);
                    string w;
                    while (ss >> w) ans[stoi(w.substr(2))]++;
                }
            }
        }
        return ans;
    }
};
