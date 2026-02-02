Problem: Divide an Array Into Subarrays With Minimum Cost II
Platform: Leetcode
Time Complexity: O(n log(dist))
Space Complexity: O(dist)


class Solution {
    multiset<int> low, high;
    long long current_sum = 0;
    int m; 

    void balance() {

        while (low.size() < m && !high.empty()) {
            int val = *high.begin();
            current_sum += val;
            low.insert(val);
            high.erase(high.begin());
        }
        while (low.size() > m) {
            int val = *low.rbegin();
            current_sum -= val;
            high.insert(val);
            low.erase(prev(low.end()));
        }
    }

    void add(int val) {
        if (low.empty() || val < *low.rbegin()) {
            low.insert(val);
            current_sum += val;
        } else {
            high.insert(val);
        }
        balance();
    }

    void remove(int val) {
        auto it = low.find(val);
        if (it != low.end()) {
            current_sum -= val;
            low.erase(it);
        } else {
            high.erase(high.find(val));
        }
        balance();
    }

public:
    long long minimumCost(vector<int>& nums, int k, int dist) {
        int n = nums.size();
        m = k - 1;
        current_sum = 0;
        low.clear();
        high.clear();

        for (int i = 1; i <= dist + 1; ++i) {
            add(nums[i]);
        }

        long long min_cost = current_sum;

        
        for (int i = 2; i <= n - dist - 1; ++i) {
            remove(nums[i - 1]);
            add(nums[i + dist]);
            min_cost = min(min_cost, current_sum);
        }

        return (long long)nums[0] + min_cost;
    }
};
