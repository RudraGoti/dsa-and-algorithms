Problem: Implement UNDO & REDO
Platform: GeeksforGeeks 
Time Complexity: O(1) 
Space Complexity: O(n) 
  

class Solution {
    Stack<Character> doc = new Stack<>();
    Stack<Character> redoStack = new Stack<>();

    public void append(char x) {
        doc.push(x);
        redoStack.clear();
    }

    public void undo() {
        if (!doc.isEmpty()) {
            redoStack.push(doc.pop());
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            doc.push(redoStack.pop());
        }
    }

    public String read() {
        StringBuilder sb = new StringBuilder();
        for (char c : doc) {
            sb.append(c);
        }
        return sb.toString();
    }
}
