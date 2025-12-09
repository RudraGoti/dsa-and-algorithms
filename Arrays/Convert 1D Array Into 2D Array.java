 // Problem: Convert 1D Array Into 2D Array
 // Platform: LeetCode 
 // Time Complexity: O(m × n)
 // Space Complexity: O(m × n)

class Solution {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int size = original.length;
      
        if (size != m * n) {
            return new int[0][0]; 
        }
    
        int[][] result = new int[m][n];
        
        for (int i = 0; i < size; i++) {
            result[i / n][i % n] = original[i];
        }
        
        return result;
    }
    
}
