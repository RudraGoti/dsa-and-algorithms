Problem: Minimum Absolute Difference
Platform: Leetcode
Time Complexity: O(n log n)
Space Complexity: O(1) 


class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
