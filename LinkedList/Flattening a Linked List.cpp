Problem: Flattening a Linked List
Platform: GeeksforGeeks
Time Complexity: O(n) 
Space Complexity: O(n) 

class Solution {
  public:
    Node* flatten(Node* root) {
        if (root == NULL || root->next == NULL)
            return root;

        root->next = flatten(root->next);
        root = merge(root, root->next);
        return root;
    }

  private:
    Node* merge(Node* a, Node* b) {
        if (a == NULL) return b;
        if (b == NULL) return a;

        Node* result;
        if (a->data < b->data) {
            result = a;
            result->bottom = merge(a->bottom, b);
        } else {
            result = b;
            result->bottom = merge(a, b->bottom);
        }

        result->next = NULL;
        return result;
    }
};
