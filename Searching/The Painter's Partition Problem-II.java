Problem: The Painter's Partition Problem-II
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(1) 


class Solution {

    private boolean canPaint(int[] arr, int k, long limit) {
        long curr = 0;
        int painters = 1;

        for (int board : arr) {
            if (curr + board <= limit) {
                curr += board;
            } else {
                painters++;
                curr = board;
                if (painters > k) return false;
            }
        }
        return true;
    }

    public int minTime(int[] arr, int k) {
        long low = 0, high = 0;

        for (int x : arr) {
            low = Math.max(low, x);
            high += x;
        }

        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canPaint(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}
