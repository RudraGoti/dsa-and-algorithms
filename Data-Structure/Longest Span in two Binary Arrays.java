Problem: Longest Span in two Binary Arrays
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(n)


class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int ans = 0;

        for(int i = 0; i < a1.length; i++) {

            prefix += (a1[i] - a2[i]);

            if(prefix == 0)
                ans = i + 1;

            if(map.containsKey(prefix))
                ans = Math.max(ans, i - map.get(prefix));
            else
                map.put(prefix, i);
        }

        return ans;
    }
}
