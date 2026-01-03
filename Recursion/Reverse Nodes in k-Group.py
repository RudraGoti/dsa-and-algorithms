Problem: Reverse Nodes in k-Group
Platform: Leetcode
Time Complexity: O(n) 
Space Complexity: O(1)

class Solution(object):
    def reverseKGroup(self, head, k):
        if not head or k == 1:
            return head

        dummy = ListNode(0)
        dummy.next = head
        prev_group = dummy

        while True:
            kth = prev_group
            for _ in range(k):
                kth = kth.next
                if not kth:
                    return dummy.next

            group_next = kth.next
            prev = group_next
            curr = prev_group.next

            while curr != group_next:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp

            temp = prev_group.next
            prev_group.next = kth
            prev_group = temp
