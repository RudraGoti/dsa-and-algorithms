Problem: Minimum Cost to Convert String II
Platform: LeetCode 
Time Complexity: O(n + k³) 
Space Complexity: O(n + k²) 


class Solution(object):
    def minimumCost(self, source, target, original, changed, cost):
        n = len(source)
        INF = 10**18
        from collections import defaultdict

        rules = defaultdict(list)
        for o, c, w in zip(original, changed, cost):
            rules[len(o)].append((o, c, w))

        conv = {}

        for L, items in rules.items():
            strs = set()
            for o, c, _ in items:
                strs.add(o)
                strs.add(c)

            strs = list(strs)
            idx = {s: i for i, s in enumerate(strs)}
            m = len(strs)

            dist = [[INF]*m for _ in range(m)]
            for i in range(m):
                dist[i][i] = 0

            for o, c, w in items:
                dist[idx[o]][idx[c]] = min(dist[idx[o]][idx[c]], w)

            for k in range(m):
                for i in range(m):
                    for j in range(m):
                        if dist[i][k] + dist[k][j] < dist[i][j]:
                            dist[i][j] = dist[i][k] + dist[k][j]

            table = {}
            for i in range(m):
                for j in range(m):
                    if dist[i][j] < INF:
                        table[(strs[i], strs[j])] = dist[i][j]

            conv[L] = table

        dp = [INF] * (n + 1)
        dp[0] = 0

        for i in range(n):
            if dp[i] == INF:
                continue

            if source[i] == target[i]:
                dp[i+1] = min(dp[i+1], dp[i])

            for L, table in conv.items():
                if i + L > n:
                    continue
                a = source[i:i+L]
                b = target[i:i+L]
                if (a, b) in table:
                    dp[i+L] = min(dp[i+L], dp[i] + table[(a, b)])

        return dp[n] if dp[n] < INF else -1
