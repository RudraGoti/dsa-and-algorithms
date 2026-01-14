Problem: Separate Squares II Attempted Hard Topics premium lock icon Companies
Platform: LeetCode
Time Complexity: O(n² log n)
Space Complexity: O(n)

class Solution {
public:
    struct Event {
        double x;
        double y1, y2;
        int type;
    };

    double unionAreaBelow(double yCut, vector<vector<int>>& squares) {
        vector<Event> events;

        for (auto &s : squares) {
            double x = s[0], y = s[1], l = s[2];
            double h = min(l, max(0.0, yCut - y));
            if (h <= 0) continue;

            events.push_back({x, y, y + h, +1});
            events.push_back({x + l, y, y + h, -1});
        }

        if (events.empty()) return 0.0;

        sort(events.begin(), events.end(),
             [](auto &a, auto &b) { return a.x < b.x; });

        multiset<pair<double,double>> active;
        double prevX = events[0].x;
        double area = 0.0;

        auto coveredY = [&]() {
            if (active.empty()) return 0.0;
            vector<pair<double,double>> v(active.begin(), active.end());
            sort(v.begin(), v.end());

            double total = 0;
            double start = v[0].first, end = v[0].second;

            for (int i = 1; i < v.size(); i++) {
                if (v[i].first > end) {
                    total += end - start;
                    start = v[i].first;
                    end = v[i].second;
                } else {
                    end = max(end, v[i].second);
                }
            }
            total += end - start;
            return total;
        };

        for (auto &e : events) {
            double dx = e.x - prevX;
            if (dx > 0) {
                area += dx * coveredY();
                prevX = e.x;
            }

            if (e.type == 1)
                active.insert({e.y1, e.y2});
            else
                active.erase(active.find({e.y1, e.y2}));
        }

        return area;
    }

    double separateSquares(vector<vector<int>>& squares) {
        double low = 1e18, high = -1e18;
        double totalArea = 0;

        for (auto &s : squares) {
            low = min(low, (double)s[1]);
            high = max(high, (double)s[1] + s[2]);
            totalArea += 1.0 * s[2] * s[2];
        }

        double target = totalArea / 2.0;

        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            if (unionAreaBelow(mid, squares) < target)
                low = mid;
            else
                high = mid;
        }

        return low;
    }
};
