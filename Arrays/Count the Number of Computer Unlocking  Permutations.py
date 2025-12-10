 // Problem: Count the Number of Computer Unlocking  Permutations
 // Platform: LeetCode 
 // Time Complexity: O(n log n)
 // Space Complexity: O(n) 

class Solution(object):
    def countPermutations(self, complexity):
        MOD = 10**9 + 7
        n = len(complexity)

        vals = sorted(set(complexity))
        comp = {v:i for i,v in enumerate(vals)}
        m = len(vals)

        INF = 10**18
        fenw = [INF] * (m + 1)

        def fenw_update(i, val):
            i += 1
            while i <= m:
                fenw[i] = min(fenw[i], val)
                i += i & -i

        def fenw_query(i):
       
            i += 1
            res = INF
            while i > 0:
                res = min(res, fenw[i])
                i -= i & -i
            return res

        parent = [-1] * n
   
        fenw_update(comp[complexity[0]], 0)

        for i in range(1, n):
            cx = comp[complexity[i]]

            j = fenw_query(cx - 1)
            if j == INF:
                return 0
            parent[i] = j

            fenw_update(cx, i)

        g = [[] for _ in range(n)]
        for i in range(1, n):
            g[parent[i]].append(i)

        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i % MOD

        import sys
        sys.setrecursionlimit(200000)
        subtree = [0] * n

        def dfs(u):
            s = 1
            for v in g[u]:
                s += dfs(v)
            subtree[u] = s
            return s

        dfs(0)

        ans = fact[n]
        for s in subtree:
            ans = ans * pow(s, MOD - 2, MOD) % MOD

        return ans
