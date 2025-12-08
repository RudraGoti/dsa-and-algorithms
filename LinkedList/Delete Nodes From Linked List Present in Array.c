// Problem: Delete Nodes From Linked List Present in Array
// Platform: LeetCode
// Time Complexity: O(N + M)
// Space Complexity: O(N + M)

class Solution {
public:
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        unordered_set<int> st;
        for (int x : nums) st.insert(x);

        ListNode* dummy = new ListNode(-1);
        ListNode* cur = dummy;

        while (head) {
            if (st.count(head->val) == 0) {
                cur->next = new ListNode(head->val);
                cur = cur->next;
            }
            head = head->next;
        }

        return dummy->next;
    }
};
