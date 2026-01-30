Problem: Interleave the First Half of the Queue with Second Half
Platform: GeeksforGeeks
Time Complexity: O(n) 
Space Complexity: O(n) 

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        int half = n / 2;

        Queue<Integer> first = new LinkedList<>();

        for (int i = 0; i < half; i++) {
            first.add(q.poll());
        }

        while (!first.isEmpty()) {
            q.add(first.poll());
            q.add(q.poll());
        }
    }
}
