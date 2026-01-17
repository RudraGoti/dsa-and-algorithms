Problem: Expression contains redundant bracket or not
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(n)


class Solution {
    public static boolean checkRedundancy(String s) {
        java.util.Stack<Character> st = new java.util.Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ')') {
                boolean hasOperator = false;
                
                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }
                
                st.pop();
                
                if (!hasOperator) return true;
            } else {
                st.push(ch);
            }
        }
        return false;
    }
}
