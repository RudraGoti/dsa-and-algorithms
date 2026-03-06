Problem: Smallest window containing all characters
Platform: GeeksforGeeks
Time Complexity: O(N + M)
                 N = length of s
                 M = length of p
Space Complexity: O(1)


class Solution {
  public:
    string minWindow(string &s, string &p) {
        int n = s.length();
        int m = p.length();
        
        if(m > n) return "";
        
        vector<int> freq(26, 0);
        
        for(char c : p)
            freq[c - 'a']++;
        
        int left = 0, count = m;
        int minLen = INT_MAX, start = 0;
        
        for(int right = 0; right < n; right++) {
            
            if(freq[s[right] - 'a'] > 0)
                count--;
            
            freq[s[right] - 'a']--;
            
            while(count == 0) {
                
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                freq[s[left] - 'a']++;
                
                if(freq[s[left] - 'a'] > 0)
                    count++;
                
                left++;
            }
        }
        
        if(minLen == INT_MAX) return "";
        
        return s.substr(start, minLen);
    }
};
