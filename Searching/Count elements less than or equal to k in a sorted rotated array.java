Problem: Count elements less than or equal to k in a sorted rotated array
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(1)

class Solution {
    public int countLessEqual(int[] arr, int x) {
        
        int c = 0;
        
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] <= x){
                c++;
            }
        }
        return c;
    }
}
