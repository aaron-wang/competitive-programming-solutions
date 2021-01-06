#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';using vi=vector<int>;
const int MM = 252;
int dp[MM][MM];
int solve(int n, int k) {
    if (!n) return 1;
    if (n < 0 || k == 0) return 0;
    if (dp[n][k])return dp[n][k];
    return (dp[n][k]=solve(n,k-1) + solve(n-k,k));
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    //cleaned up code 
    //from previous java submission
    int n,k; cin >>n>>k;
    int ans = solve(n-k,k);
    cout << ans << nl;
}