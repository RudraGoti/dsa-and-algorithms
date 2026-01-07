Problem: Missing and Repeating 
Platform: GeeksforGeeks
Time Complexity: O(n) 
Space Complexity: O(1) 

class Solution {
public:
    vector<int> findTwoElement(vector<int> arr) {
        long long n = arr.size();

        long long S = n * (n + 1) / 2;                      
        long long S2 = n * (n + 1) * (2*n + 1) / 6;         

        long long A = 0, A2 = 0;
        for (long long x : arr) {
            A += x;
            A2 += (long long)x * x;
        }

        long long diff = A - S;                             
        long long diff2 = A2 - S2;                          

        long long sum_xy = diff2 / diff;                    

        long long x = (diff + sum_xy) / 2;                  
        long long y = x - diff;                             

        return {(int)x, (int)y};
    }
};
