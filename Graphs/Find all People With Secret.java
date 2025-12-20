// Problem: Find all People With Secret
// Platform: Leetcode 
// Time Complexity: O(n lon n) 
// Space Complexity: O(n + m) 

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

        int i = 0;
        int m = meetings.length;

        while (i < m) {
            int time = meetings[i][2];

            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> peopleInTime = new HashSet<>();

            while (i < m && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                peopleInTime.add(x);
                peopleInTime.add(y);

                i++;
            }

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int person : peopleInTime) {
                if (knows[person]) {
                    queue.offer(person);
                    visited.add(person);
                }
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        knows[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (knows[p]) {
                result.add(p);
            }
        }

        return result;
    }
}
