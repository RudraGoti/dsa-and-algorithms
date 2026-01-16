Problem: Minimum Number of Workers
Platform: GeeksforGeeks
Time Complexity: O(n log n) 
Space Complexity: O(n) 


class Solution {
    public int minMen(int arr[]) {
        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int l = Math.max(0, i - arr[i]);
                int r = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{l, r});
            }
        }

        intervals.sort((a, b) -> a[0] - b[0]);

        int ans = 0, i = 0, covered = 0;

        while (covered < n) {
            int farthest = covered;

            while (i < intervals.size() && intervals.get(i)[0] <= covered) {
                farthest = Math.max(farthest, intervals.get(i)[1] + 1);
                i++;
            }

            if (farthest == covered) return -1;

            ans++;
            covered = farthest;
        }

        return ans;
    }
}
