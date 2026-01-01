Problem: Intersection in Y Shaped List
Platform: GeeksforGeeks
Time Complexity: O(n + m)
Space Complexity: O(1)

  class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        Node p1 = head1, p2 = head2;

        while (p1 != p2) {
            p1 = (p1 == null) ? head2 : p1.next;
            p2 = (p2 == null) ? head1 : p2.next;
        }

        return p1;
    }
}
