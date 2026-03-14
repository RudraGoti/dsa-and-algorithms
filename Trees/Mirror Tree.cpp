Problem: Mirror Tree
Platform: GeekforGeeks
Time Complexity: O(N) (visit every node once)
Space Complexity: O(H) recursion stack (H = tree height)


class Solution {
  public:
    void mirror(Node* root) {
        if(!root) return;
        
        swap(root->left, root->right);
        
        mirror(root->left);
        mirror(root->right);
    }
};
