Problem: Equalize the Towers
Platform: GeeksforGeeks
Time Complexity: O(n log n)
Space Complexity: O(n)


class Solution {
    public long minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int[][] towers = new int[n][2];

        for (int i = 0; i < n; i++) {
            towers[i][0] = heights[i];
            towers[i][1] = cost[i];
        }

        Arrays.sort(towers, (a, b) -> Integer.compare(a[0], b[0]));

        long totalWeight = 0;
        for (int c : cost) totalWeight += c;

        long currWeight = 0;
        int targetHeight = 0;

        for (int[] t : towers) {
            currWeight += t[1];
            if (currWeight * 2 >= totalWeight) {
                targetHeight = t[0];
                break;
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) Math.abs(heights[i] - targetHeight) * cost[i];
        }

        return ans;
    }
}
