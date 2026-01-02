Problem: N-Repeated Element in Size 2N Array
Platform: LeetCode
Time Complexity: O(n)
Space Complexity: O(1)

class Solution {
    public int repeatedNTimes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
            if (i + 2 < len && nums[i] == nums[i + 2]) return nums[i];
            if (i + 3 < len && nums[i] == nums[i + 3]) return nums[i];
        }
        return 1;
    }
}
