Problem: Top View of Binary Tree
Platform: GeeksforGeeks
Time Complexity: O(N log N) 
Space Complexity: O(N)

class Solution {
  public:
    vector<int> topView(Node *root) {
        vector<int> res;
        if(!root) return res;

        map<int,int> mp;
        queue<pair<Node*,int>> q;

        q.push({root,0});

        while(!q.empty()){
            auto p = q.front();
            q.pop();

            Node* node = p.first;
            int hd = p.second;

            if(mp.find(hd) == mp.end())
                mp[hd] = node->data;

            if(node->left) q.push({node->left, hd-1});
            if(node->right) q.push({node->right, hd+1});
        }

        for(auto it : mp)
            res.push_back(it.second);

        return res;
    }
};
