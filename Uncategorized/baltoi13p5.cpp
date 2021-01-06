#include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n';
typedef pair<int,int> pii;
const int MM = 4005;
char g[MM][MM];
bool vis[MM][MM];
int H, W,ans;
//new : use for direction, rather than chained if
int dir[4][2] = {{-1,0},{1,0},{0,-1},{0,1}};
queue<pii> q[2];
void bfs() {
    while(!q[0].empty()) {
        int r = q[0].front().first;
        int c = q[0].front().second;
        q[0].pop();
        for (int k = 0; k < 4; k++) {
            int R = r + dir[k][0];
            int C = c + dir[k][1];
            if (R < 1 || R > H) continue;
            if (C < 1 || C > W) continue;
            if (vis[R][C] || g[R][C] == '.') continue;
            if (g[R][C] == g[r][c]) {
                q[0].push({R,C});
            }
            else {
                //not equal - different;
                q[1].push({R,C});
            }
            vis[R][C] = true;
        }
        
    }
}
int main() {
    cin.sync_with_stdio(false);
    cin.tie(0);
    cin >> H >> W;

    for (int i = 1; i <=H; i++) {
        for (int j = 1; j <= W; j++) {
            cin >> g[i][j];
        }
    }
    q[0].push({1,1});
    vis[1][1] = true;
    while (true) {
        ans++;
        bfs();
        if (q[1].empty()) break;
        swap(q[0],q[1]);
    }
    cout << ans << nl;

}