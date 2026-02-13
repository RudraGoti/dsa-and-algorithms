Problem: All numbers with specific difference
Platform: GeeksforGeeks
Time Complexity: O(1) 
Space Complexity: O(1) 


class Solution {
  public:
    int getCount(int n, int d) {
        int cnt = 0;

        int start = max(1, d);
        int end = min(n, d + 89);

        for (int x = start; x <= end; x++) {
            int s = 0, t = x;
            while (t) {
                s += t % 10;
                t /= 10;
            }
            if (x - s >= d) cnt++;
        }

        if (n >= d + 90) {
            cnt += n - (d + 90) + 1;
        }

        return cnt;
    }
};
