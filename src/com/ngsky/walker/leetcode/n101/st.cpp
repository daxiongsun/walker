#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <queue>

using namespace std;

int que[1000000];
int s,e;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        
        int ns=s,ne=e-1;
        bool yes=true;
        while((ne-ns)>0){
            if(que[ne]!=que[ns]){
                yes=false;
                break;
            }
        }
        if(!yes) return false;
        else {
            
        }

    }
};

// int main(){

//     return 0;
// }