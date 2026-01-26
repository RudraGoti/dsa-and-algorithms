Problem: Generate Permutations of an array
Platform: GeeksforGeeks
Time Complexity: O(n × n!)
Space Complexity: O(n) 

class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(0, arr, result);
        return result;
    }

    private static void backtrack(int index, int[] arr,
                                  ArrayList<ArrayList<Integer>> result) {
        if (index == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : arr) temp.add(num);
            result.add(temp);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            backtrack(index + 1, arr, result);
            swap(arr, index, i); // backtrack
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
