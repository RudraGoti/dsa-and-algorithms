Problem: Subarrays With At Most K Distinct Integers
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(k)

class Solution {
    public long countAtMostK(int[] arr, int k) {
        if (k == 0) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long count = 0;

        for (int right = 0; right < arr.length; right++) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            while (freq.size() > k) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) {
                    freq.remove(arr[left]);
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
