Problem: Coupon Code Validator
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(1) 


class Solution {
public:
    void sort012(vector<int>& arr) {
        int c0 = 0, c1 = 0, c2 = 0;

        for (int x : arr) {
            if (x == 0) c0++;
            else if (x == 1) c1++;
            else c2++;
        }

        int i = 0;
        while (c0--) arr[i++] = 0;
        while (c1--) arr[i++] = 1;
        while (c2--) arr[i++] = 2;
    }
};
