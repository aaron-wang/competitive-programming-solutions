#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl = '\n';
const int MM = 1e6+6;
int n,m;
double dp[MM];vector<int> adj[MM];
int main() {
    cin.sync_with_stdio(0);cin.tie(0);
    cin >> n >> m; 
    for (int i = 0; i < m; i++) {
        int x,y;cin >> x >> y;
        adj[x].pb(y);
    }
    dp[1]=1;
    for (int i = 1;i <= n; i++) {
        bool ran = false;
        for (int x: adj[i]) {
            ran = true;
            dp[x] += dp[i]/ (double)adj[i].size();
        }
        if (!ran) cout << fixed << setprecision(9) << dp[i] <<nl;
    }
}