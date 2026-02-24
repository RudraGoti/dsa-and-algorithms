Problem: Binary Gap
Platform: LeetCode
Time Complexity: O(log N)
Space Complexity: O(1)


class Solution {
public:
    int binaryGap(int n) {
        int last = -1, ans = 0, pos = 0;

        while (n > 0) {
            if (n & 1) {
                if (last != -1)
                    ans = max(ans, pos - last);
                last = pos;
            }
            pos++;
            n >>= 1;
        }
        return ans;
    }
};
