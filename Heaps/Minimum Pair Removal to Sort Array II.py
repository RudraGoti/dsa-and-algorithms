Problem: Minimum Pair Removal to Sort Array II
Platform: Leetcode 
Time Complexity: O(n log n) 
Space Complexity: O(n)


class Node:
    def __init__(self, val, rank):
        self.val = val
        self.rank = rank
        self.prev = None
        self.next = None
        self.active = True

class Solution(object):
    def minimumPairRemoval(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n < 2:
            return 0
            
        nodes = [Node(x, i) for i, x in enumerate(nums)]
        for i in range(n):
            if i > 0: nodes[i].prev = nodes[i-1]
            if i < n - 1: nodes[i].next = nodes[i+1]
            
        head = nodes[0]
        
        bad_pairs = 0
        curr = head
        while curr and curr.next:
            if curr.val > curr.next.val:
                bad_pairs += 1
            curr = curr.next
            
        if bad_pairs == 0:
            return 0
            
        pq = []
        curr = head
        while curr and curr.next:
            s = curr.val + curr.next.val
            heapq.heappush(pq, (s, curr.rank, curr))
            curr = curr.next
            
        ops = 0
        
        while bad_pairs > 0 and pq:
            s, r, node = heapq.heappop(pq)
            
            if not node.active or not node.next or (node.val + node.next.val != s):
                continue
                
            ops += 1
            right = node.next
            
            if node.prev and node.prev.val > node.val:
                bad_pairs -= 1
            if node.val > right.val:
                bad_pairs -= 1
            if right.next and right.val > right.next.val:
                bad_pairs -= 1
                
            node.val = node.val + right.val
            
            node.next = right.next
            if node.next:
                node.next.prev = node
            right.active = False
            
            if node.prev and node.prev.val > node.val:
                bad_pairs += 1
            if node.next and node.val > node.next.val:
                bad_pairs += 1
                
            if node.prev:
                new_s_prev = node.prev.val + node.val
                heapq.heappush(pq, (new_s_prev, node.prev.rank, node.prev))
                
            if node.next:
                new_s_next = node.val + node.next.val
                heapq.heappush(pq, (new_s_next, node.rank, node))
                
        return ops
