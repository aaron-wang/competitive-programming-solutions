#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
const int MM = 1e3+5;
int C,R; 
int a[MM][MM], dp[MM][MM];
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> C >> R;
    for (int i = 1; i <= R; i++) {
        for (int j = 1; j <= C; j++) {
            cin >> a[i][j];
        }
    }
    int l,d; cin >> l >> d;
    memset(dp,0x3f3f3f3f,sizeof(dp));
    dp[0][1] = 0;
    dp[1][0] = 0;
    for (int i = 1; i <= R; i++) {
        for (int j = 1; j <= C; j++) {
            dp[i][j] = a[i][j];
            dp[i][j] += min(dp[i-1][j],dp[i][j-1]);
        }
        for (int j = C; j >= 1; j--) {
            dp[i][j] = min(dp[i][j],a[i][j]+dp[i][j+1]);
        }
    }
    // cout << "_-------"<<nl;
    cout << dp[d+1][l+1] << nl;
    // for (int i = 1; i <= R; i++) {
    //     for (int j = 1; j <= C; j++) {
    //         cout << dp[i][j] << " ";
    //     }cout << nl;
    // }
}