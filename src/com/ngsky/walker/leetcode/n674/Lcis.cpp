#include <stdio.h>

using namespace std;

#define ARRAY_SIZE(x) (sizeof(x)/sizeof((x)[0]))

// 坐标型动态规划
int findLengthOfLCIS(int* nums, int numsSize){
    // dp[i]: 以nums[i]结尾的递增子序列长度
    if(numsSize==0) return 0;
    int dp[numsSize];
    // 状态转移方程：dp[i]=dp[i-1]+1
    //             dp[i]=1
    int res;
    for(int i=0;i<numsSize;i++){
        // option 1: 
        dp[i]=1;
        // option 2: 
        if(i>0&&nums[i-1]<nums[i]){
            dp[i]=dp[i-1]+1;
        }
        if(dp[i]>res){
            res=dp[i];
        }
    }
    return res;
}

int main(){ 
    int nums[]={2,2,2,2,2};
    int res=findLengthOfLCIS(nums, ARRAY_SIZE(nums));
    printf("%d\n", res);
    return 0;
}