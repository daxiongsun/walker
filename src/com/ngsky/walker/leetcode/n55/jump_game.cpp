#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n=nums.size();
        // dp[i]: 能否调到位置i
        bool dp[n];
        dp[0]=true;
        for(int i=0;i<n;i++){
            bool f=false;
            for(int j=i;j<n;j++){
                if(dp[j]==true && (j+nums[j] >=i)) {
                    f=true;
                    break;
                }
            }
            dp[i]=f;
        }
        return dp[n-1];
    }
};