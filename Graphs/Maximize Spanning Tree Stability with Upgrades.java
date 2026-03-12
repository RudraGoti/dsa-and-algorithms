Problem: Maximize Spanning Tree Stability with Upgrades
Platform: LeetCode 
Time Complexity: O(E log W)
Space Complexity: O(n) 


class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    boolean can(int n, int[][] edges, int k, int x) {
        DSU dsu = new DSU(n);
        int used = 0;
        int upgrades = 0;

        List<int[]> up = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < x) return false;
                if (!dsu.union(u, v)) return false;
                used++;
            }
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 1) continue;

            if (s >= x) {
                if (dsu.union(u, v)) used++;
            } else if (2 * s >= x) {
                up.add(e);
            }
        }

        for (int[] e : up) {
            if (upgrades == k) break;

            if (dsu.union(e[0], e[1])) {
                upgrades++;
                used++;
            }
        }

        return used == n - 1;
    }

    public int maxStability(int n, int[][] edges, int k) {

        int lo = 1, hi = 200000;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (can(n, edges, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}
