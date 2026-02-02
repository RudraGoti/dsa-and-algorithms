Problem: Max Circular Subarray Sum
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(1)


class Solution {
public:
    int maxCircularSum(vector<int> &arr) {
        int totalSum = 0;

        int maxKadane = arr[0], currMax = 0;
        int minKadane = arr[0], currMin = 0;

        for (int x : arr) {
            currMax = max(x, currMax + x);
            maxKadane = max(maxKadane, currMax);

            currMin = min(x, currMin + x);
            minKadane = min(minKadane, currMin);

            totalSum += x;
        }

        if (maxKadane < 0)
            return maxKadane;

        return max(maxKadane, totalSum - minKadane);
    }
};
