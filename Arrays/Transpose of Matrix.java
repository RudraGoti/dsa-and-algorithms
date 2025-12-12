 // Problem: Transpose of Matrix
 // Platform: GeeksgorGeeks 
 // Time Complexity: O(n^2) 
 // Space Complexity: O(n^2) 

class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        int n = mat.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(mat[j][i]);
            }
            res.add(row);
        }
        return res;
    }
}
