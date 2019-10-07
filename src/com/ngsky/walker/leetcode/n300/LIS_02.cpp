#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size();
        if(n==0) return 0;
        // dp[i]:以nums[i]结尾的最长上升子序列的长度
        int dp[n];
        for(int i=0;i<n;i++){dp[i]=1;}
        for(int i=1;i<n;i++){
            int cl=nums[i];
            for(int j=0;j<i;j++){
                if(cl>nums[j]) dp[i]=max(dp[j]+1,dp[i]);
            }
        }
        int res=dp[0];
        for(int i=0;i<n;i++) res=max(res,dp[i]);
        return res;
    }
};