#include <iostream>
#include <cstring>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

using ll=long long;

#define REP(i, n) for(ll i = 0; i != n; ++i)
#define REPR(i, n) for(int i = n - 1; i != -1; --i)
#define FOR(i, a, b) for(int i = a; i != b; ++i)
#define RBF(i, n) for(auto &i : n)
#define ABS(n) (n < 0 ? -n : n)
#define MIN(a, b) (a < b ? a : b)
#define MAX(a, b) (a > b ? a : b)
#define IN(n) (cin >> n)
#define OUT(n) (cout << n << "\n")
#define INF 1e9
#define ALL(v) (v).begin(), (v).end()

ll euclidean_gcd(ll a,ll b){
    if(a<b) return euclidean_gcd(b,a);
    ll r;
    while((r==a%b)){
        a=b;
        b=r;
    }
    return b;
}

vector<ll> ans;
int make_divisors(ll n){
    // sqrt 根号下
    for(ll i=1;i<ll(sqrt(n))+1;++i){
        if(n%i==0){
            ans.push_back(i);
            if(i!=n/i) ans.push_back(n/i);
        }
    }
    sort(ans.begin(),ans.end());
    return 0;
}

bool IsPrime(ll num){
    if(num<2) return true;
    else if(num==2) return true;
    else if(num%2==0) return false;
    long double sqrtNum=sqrt(num);
    for(ll i=3;i<=sqrtNum;i+=2){
        if(num%i==0) return false;
    }
    return true;
}

int main(){
    // freopen("in.txt", "r", stdin);

    cin.tie(0);
    // 原来而cin，cout之所以效率低，是因为先把要输出的东西存入缓冲区，再输出，导致效率降低，
    // 而这段语句可以来打消iostream的输入 输出缓存，可以节省许多时间，使效率与scanf与printf相差无几，
    // 还有应注意的是scanf与printf使用的头文件应是stdio.h而不是 iostream。
    ios::sync_with_stdio(false);

    ll A,B;
    cin >> A >> B;
    ll x=euclidean_gcd(A,B);
    make_divisors(x);
    vector<ll> sosu;
    REP(i,ans.size()) if(IsPrime(ans[i])) sosu.push_back(ans[i]);
    OUT(sosu.size());

    return 0;
}