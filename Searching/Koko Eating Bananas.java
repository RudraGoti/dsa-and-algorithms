Problem: Koko Eating Bananas
Platform: GeeksforGeeks 
Time Complexity: O(n log max(arr))
Space Complexity: O(1) 


class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = 0;

        for (int a : arr) {
            high = Math.max(high, a);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hours = 0;

            for (int a : arr) {
                hours += (a + mid - 1) / mid;
            }

            if (hours <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
