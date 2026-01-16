Problem: Maximum Square Area by Removing Fences From a Field
Platform: LeetCode 
Time Complexity: O(H² + V²)
Space Complexity: O(H²)


class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007L;

        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        h.add(1);
        h.add(m);
        for (int x : hFences) h.add(x);

        v.add(1);
        v.add(n);
        for (int x : vFences) v.add(x);

        Collections.sort(h);
        Collections.sort(v);

        Set<Long> hs = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                hs.add((long) h.get(j) - h.get(i));
            }
        }

        long max = -1;
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                long d = (long) v.get(j) - v.get(i);
                if (hs.contains(d)) {
                    max = Math.max(max, d);
                }
            }
        }

        if (max == -1) return -1;
        return (int) ((max * max) % MOD);
    }
}
