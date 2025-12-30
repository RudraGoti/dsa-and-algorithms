Problem: Add Number Linked Lists
Platform: GeeksforGeeks
Time Complexity: O(N + M)
Space Complexity: O(1)

class Solution {

    Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head == null ? new Node(0) : head;
    }

    public Node addTwoLists(Node head1, Node head2) {

        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);

        head1 = reverse(head1);
        head2 = reverse(head2);

        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            curr.next = new Node(sum % 10);
            curr = curr.next;
            carry = sum / 10;
        }

        return reverse(dummy.next);
    }
}
