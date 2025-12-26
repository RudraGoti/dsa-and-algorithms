// Problem: Kth Missing Positive Number in a Sorted Array
// Platform: GeeksforGeeks 
// Time Complexity: O(n log n) 
// Space Complexity: O(1) 

class Solution {
    public int kthMissing(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low + k;
    }
}
