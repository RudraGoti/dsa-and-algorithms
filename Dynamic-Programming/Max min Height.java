Problem: Max min Height
Platform: GeekssforGeeks
Time Complexity: O(n log k) 
Space Complexity: O(n) 


class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Integer.MAX_VALUE;

        for (int x : arr) low = Math.min(low, x);
        int high = low + k;
        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canMake(int[] arr, int k, int w, int target) {
        int n = arr.length;
        long[] diff = new long[n + 1];
        long used = 0, curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i];
            long height = arr[i] + curr;

            if (height < target) {
                long need = target - height;
                used += need;
                if (used > k) return false;

                curr += need;
                if (i + w < n) diff[i + w] -= need;
            }
        }
        return true;
    }
}
