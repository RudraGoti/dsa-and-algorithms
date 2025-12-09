 // Problem: Clone Graph
 // Platform: LeetCode 
 // Time Complexity: O(n + e) 
 // Space Complexity: O(n) 


class Solution(object):
    def cloneGraph(self, node):
        if not node:
            return None

        visited = {}

        def dfs(curr):
            if curr in visited:
                return visited[curr]
            
            copy = Node(curr.val)
            visited[curr] = copy

            for nei in curr.neighbors:
                copy.neighbors.append(dfs(nei))
            
            return copy

        return dfs(node)
