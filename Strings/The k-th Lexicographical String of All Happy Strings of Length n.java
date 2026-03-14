Problem: The k-th Lexicographical String of All Happy Strings of Length n
Platform: LeetCode 
Time Complexity: O(2^n) 
Space Complexity: O(n)

class Solution {
    int count = 0;
    String ans = "";

    public String getHappyString(int n, int k) {
        dfs(n, k, new StringBuilder());
        return ans;
    }

    void dfs(int n, int k, StringBuilder sb) {
        if (sb.length() == n) {
            count++;
            if (count == k) ans = sb.toString();
            return;
        }

        for (char c : new char[]{'a','b','c'}) {
            if (sb.length() > 0 && sb.charAt(sb.length()-1) == c) continue;

            sb.append(c);
            dfs(n, k, sb);
            sb.deleteCharAt(sb.length()-1);

            if (!ans.equals("")) return;
        }
    }
}
