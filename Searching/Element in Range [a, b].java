// Problem: Element in Range [a, b]
// Platform: GeeksforGeeks 
// Time Complexity: O(n log n + q log n) 
// Space Complexity: O(1) 

class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            ans.add(upperBound(arr, q[1]) - lowerBound(arr, q[0]));
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
