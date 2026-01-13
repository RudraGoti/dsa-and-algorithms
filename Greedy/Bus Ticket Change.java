Problem: Bus Ticket Change
Platform: LeetCode
Time Complexity: O(n)
Space Complexity: O(1)

class Solution {
    public boolean canServe(int[] arr) {
        int five = 0, ten = 0;

        for (int note : arr) {
            if (note == 5) {
                five++;
            } else if (note == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
