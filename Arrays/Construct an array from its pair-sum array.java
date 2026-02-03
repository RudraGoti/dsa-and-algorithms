Problem: Construct an array from its pair-sum array
Platform: GeeksforGeeks 
Time Complexity: O(n^2)
Space Complexity: O(n) 


import java.util.*;
class Solution {
    public static ArrayList<Integer> constructArr(int arr[]) {
        int m = arr.length;

        if (m == 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);
            ans.add(arr[0] - 1);
            return ans;
        }

        int n = (1 + (int)Math.sqrt(1 + 8L * m)) / 2;
        long[] res = new long[n];

        long S1 = arr[0];
        long S2 = arr[1];
        long S3 = arr[n - 1];

        res[0] = (S1 + S2 - S3) / 2;

        for (int i = 1; i < n; i++) {
            res[i] = arr[i - 1] - res[0];
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (k >= m || res[i] + res[j] != arr[k]) {
                    return new ArrayList<>();
                }
                k++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (long x : res) ans.add((int)x);
        return ans;
    }

    public static boolean isPossible(int arr[]) {
        ArrayList<Integer> r = constructArr(arr);
        return !r.isEmpty();
    }
}
