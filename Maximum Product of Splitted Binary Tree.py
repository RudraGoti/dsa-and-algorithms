Problem: Maximum Product of Splitted Binary Tree
Platform: LeetCode
Time Complexity: O(N)
Space Complexity: O(Height)

class Solution(object):
    def maxProduct(self, root):
        MOD = 10**9 + 7
        self.max_product = 0

        def totalSum(node):
            if not node:
                return 0
            return node.val + totalSum(node.left) + totalSum(node.right)

        total = totalSum(root)

        def subtreeSum(node):
            if not node:
                return 0
            curr = node.val + subtreeSum(node.left) + subtreeSum(node.right)
            self.max_product = max(self.max_product, curr * (total - curr))
            return curr

        subtreeSum(root)
        return self.max_product % MOD
