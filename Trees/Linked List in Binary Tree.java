Problem: Linked List in Binary Tree
Platform: LeetCode
Time Complexity: O(N × M)
Space Complexity: O(N) worst-case, O(log N) average

public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, head, root);
    }
    
    private boolean dfs(ListNode head, ListNode cur, TreeNode root) {
        if (cur == null) return true; 
        if (root == null) return false; 
        
        if (cur.val == root.val) {
            cur = cur.next;  
        } else if (head.val == root.val) {
            head = head.next; 
        } else {
            cur = head;  
        }
        
        return dfs(head, cur, root.left) || dfs(head, cur, root.right); 
    }
}
