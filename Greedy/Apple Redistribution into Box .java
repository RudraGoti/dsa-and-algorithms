// Problem: Apple Redistribution into Box 
// Platform: LeetCode
// Time Complexity: O(n + m log m)
// Space Complexity: O(1)

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int t = 0;
        for (int x : apple) {
            t += x;
        }

        Arrays.sort(capacity);

        for (int i = 0, j = capacity.length - 1; i < j; i++, j--) {
            int temp = capacity[i];
            capacity[i] = capacity[j];
            capacity[j] = temp;
        }

        int c = 0;
        for (int i = 0; i < capacity.length; i++) {
            c += capacity[i];
            if (c >= t) {
                return i + 1;
            }
        }

        return capacity.length;
    }
}
