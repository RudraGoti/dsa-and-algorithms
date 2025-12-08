// Problem: Walking Robot Simulation
// Platform: LeetCode
// Time Complexity: O(k log k + S log k)
// Space Complexity: O(1)

import java.util.*;

class Solution {
    public int robotSim(int[] cmd, int[][] obs) {

        Arrays.sort(obs, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int n = obs.length;
        int d = 0;          
        int x = 0, y = 0;   
        int ans = 0;

        for (int c : cmd) {

            if (c == -2) d = (d + 3) % 4;     
            else if (c == -1) d = (d + 1) % 4; 
            else {
                for (int i = 0; i < c; i++) {

                    int nx = x + (d == 1 ? 1 : d == 3 ? -1 : 0);
                    int ny = y + (d == 0 ? 1 : d == 2 ? -1 : 0);

                    int l = 0, r = n;
                    while (l < r) {
                        int m = (l + r) / 2;
                        if (obs[m][0] >= nx) r = m;
                        else l = m + 1;
                    }

                    boolean block = false;
                    while (l < n && obs[l][0] == nx) {
                        if (obs[l][1] == ny) {
                            block = true;
                            break;
                        }
                        l++;
                    }

                    if (!block) {
                        x = nx;
                        y = ny;
                    } else break;
                }

                ans = Math.max(ans, x * x + y * y);
            }
        }
        return ans;
    }
}
