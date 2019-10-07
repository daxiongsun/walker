#include<cstdio>
#include<cstring>
#include<bits/stdc++.h>
using namespace std;

#define ll long long
#define inf 1e18

const int MAXN=3e5+10;
int n,m;
ll k;
ll dp[MAXN][20];
ll arr[MAXN];

int main(){
    scanf("%d%d%lld", &n,&m,&k);
    for(int i=1;i<=n;i++) scanf("%lld",&arr[i]);
    for(int i=0;i<=n;i++)
        for(int j=0;j<m;j++) dp[i][j]=-inf;
    ll ans=0;
    for(int i=1;i<=n;i++)
        for(int j=0;j<m;j++){
            if(j==1||m==1){
                dp[i][j]=max(dp[i-1][0]+arr[i]-k,arr[i]-k);
            } else if(j==0) dp[i][j]=dp[i-1][m-1]+arr[i];
            else dp[i][j]=dp[i-1][j-1]+arr[i];
            ans=max(ans,dp[i][j]);
        }
    printf("%lld\n",ans);
}