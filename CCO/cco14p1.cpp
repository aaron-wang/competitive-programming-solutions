#include <bits/stdc++.h>
using namespace std;
using ll = long long; constexpr char nl= '\n';
using vi = vector<int>; using pi = pair<int,int>;
const int MM = 2003;
char b[MM][MM];
int dp[MM][MM];
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    // freopen("in.txt","r",stdin);
    // freopen("out.txt","w",stdout);
    int n; cin >> n;
    memset(b,'.',sizeof(b));
    for (int i =0 ; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> b[i][j];
            if (b[i][j] == '#') {
                dp[i][j] = 1;
            }
        }
    }
    for (int i = n-1; i >= 0; i--) {
        for (int j = 0; j < n; j++) {
            if (dp[i][j] == 0) continue;
            int x = dp[i+1][j-1] + dp[i+1][j] + dp[i+1][j+1];
            // dp[i][j] += (x/3);
            int y = min(min(dp[i+1][j-1],dp[i+1][j]),dp[i+1][j+1]);
            dp[i][j] += y;
            // if (x >= 3) {
                // dp[i][j]++;
            // }
        }
    }
    ll ans =0 ;
    for (int i = 0; i < n; i++) {
        for (int j= 0; j < n; j++) {
            ans +=dp[i][j];
            // cout << dp[i][j] << " ";
        }
    }
    cout << ans << nl;
}