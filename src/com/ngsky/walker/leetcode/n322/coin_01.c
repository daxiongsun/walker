#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n=coins.size();
        // dp[i]: 能够拼凑为 i 元，所需要的最少的硬币数量。
        int dp[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            dp[i]=INT_MAX;
            for(int j=0;j<n;j++){
                if(coins[j]<=i&&dp[i-coins[j]]!=INT_MAX && dp[i-coins[j]]+1<dp[i]){
                    dp[i]=dp[i-coins[j]]+1;
                }
            }
        }
        return dp[amount]==INT_MAX?-1:dp[amount];
    }  
};