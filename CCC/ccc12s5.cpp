#include <bits/stdc++.h>
using namespace std; using ll = long long; constexpr char nl= '\n';
const int MM = 30;
bool cat[MM][MM];
int R,C;
ll dp[MM][MM];
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> R>> C;
    //
    int k; cin >> k;
    for (int i = 0; i < k; i++) {
        int r,c; cin >> r >> c;
        cat[r][c] = true;
    }
    dp[1][1] =1;
    for (int i = 1; i <= R; i++) {
        for (int j = 1; j <= C; j++) {
            if (cat[i][j]) continue;
            dp[i][j] += (cat[i-1][j] ? 0 : dp[i-1][j]);
            dp[i][j] += (cat[i][j-1] ? 0 : dp[i][j-1]);
        }
    }
    cout << dp[R][C] << nl;
}