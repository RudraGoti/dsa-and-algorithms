Problem: Minimum Cost Path with Edge Reversals
Platform: Leetcode
Time Complexity: O(n log(max-min))
Space Complexity: O(1) 


class Solution {
    class Pair {
        int node;
        long cost;
        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, 2L * w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.cost > dist[cur.node]) continue;

            for (Pair nxt : graph.get(cur.node)) {
                long nd = cur.cost + nxt.cost;
                if (nd < dist[nxt.node]) {
                    dist[nxt.node] = nd;
                    pq.add(new Pair(nxt.node, nd));
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}
