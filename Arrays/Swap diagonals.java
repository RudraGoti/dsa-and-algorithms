// Problem: Swap diagonals
 // Platform: GeeksgorGeeks 
 // Time Complexity: O(n^2) 
 // Space Complexity: O(1)

class Solution {
    public void swapDiagonal(int[][] mat) {
        
        int n = mat.length;
        
        for (int i = 0; i < n; i++) {
            int temp = mat[i][i];
            mat[i][i] = mat[i][n - 1 - i];
            mat[i][n - 1 - i] = temp;
        }
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
        
    }
}
