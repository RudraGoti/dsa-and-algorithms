Problem: Burning Tree
Platform: GeeksforGeeks
Time Complexity: O(n)
Space Complexity: O(n)

class Solution {
  public:
    int minTime(Node* root, int target) {
        unordered_map<Node*, Node*> parent;
        queue<Node*> q;
        q.push(root);
        Node* targetNode = NULL;

        while (!q.empty()) {
            Node* curr = q.front(); q.pop();
            if (curr->data == target) targetNode = curr;

            if (curr->left) {
                parent[curr->left] = curr;
                q.push(curr->left);
            }
            if (curr->right) {
                parent[curr->right] = curr;
                q.push(curr->right);
            }
        }

        unordered_set<Node*> visited;
        q.push(targetNode);
        visited.insert(targetNode);

        int time = 0;

        while (!q.empty()) {
            int size = q.size();
            bool burned = false;

            for (int i = 0; i < size; i++) {
                Node* curr = q.front(); q.pop();

                if (curr->left && !visited.count(curr->left)) {
                    visited.insert(curr->left);
                    q.push(curr->left);
                    burned = true;
                }

                if (curr->right && !visited.count(curr->right)) {
                    visited.insert(curr->right);
                    q.push(curr->right);
                    burned = true;
                }

                if (parent.count(curr) && !visited.count(parent[curr])) {
                    visited.insert(parent[curr]);
                    q.push(parent[curr]);
                    burned = true;
                }
            }

            if (burned) time++;
        }

        return time;
    }
};
