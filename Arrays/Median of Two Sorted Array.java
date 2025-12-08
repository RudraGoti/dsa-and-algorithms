// Problem: Median of Two Sorted Array
// Platform: LeetCode
// Time Complexity: O(log(min(m, n)))
// Space Complexity: O(1)

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length, n = b.length;

        
        if (m > n) return findMedianSortedArrays(b, a);

        int l = 0, r = m;

        while (l <= r) {
            int pa = (l + r) / 2;       
            int pb = (m + n + 1) / 2 - pa; 

            int la = (pa == 0) ? Integer.MIN_VALUE : a[pa - 1];
            int ra = (pa == m) ? Integer.MAX_VALUE : a[pa];

            int lb = (pb == 0) ? Integer.MIN_VALUE : b[pb - 1];
            int rb = (pb == n) ? Integer.MAX_VALUE : b[pb];

            if (la <= rb && lb <= ra) {
                
                if ((m + n) % 2 == 0)
                    return (Math.max(la, lb) + Math.min(ra, rb)) / 2.0;
                else
                    return Math.max(la, lb);
            }
            else if (la > rb) r = pa - 1;
            else l = pa + 1;
        }

        return 0.0;
    }
}
