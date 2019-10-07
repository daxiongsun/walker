#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

class Solution {
public:
    int numDecodings(string s) {
        int n=s.length();
        if(n==0) return 0;
        // dp[i]:前i个字符解密方式数量
        int dp[n+1];
        // 空串代表一种
        dp[0]=1;
        for(int i=1;i<=n;++i){
            dp[i]=0;
            int t=s[i-1]-'0';
            if(t>=1 && t<=9){
                dp[i]+=dp[i-1];
            }
            if(i>=2){
                t=(s[i-2]-'0')*10+(s[i-1]-'0');
                if(t>=10&&t<=26){
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[n];
    }
};

int main(){
    string s;
    cin >> s;

    Solution so;
    int res=so.numDecodings(s);
    cout << res << endl;
    return 0;
}