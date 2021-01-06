#include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n';
const int MM = 1501;
int N, dir[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
bool vis[MM][MM];
bool block[MM][MM];
short h[MM][MM], H;
void bfs(int a, int b) {
    queue<pair<int,int>> q;
    q.push({a,b});
    vis[a][b] = true;

    while (!q.empty()) {
        int r = q.front().first; 
        int c = q.front().second;
        q.pop();
        for (int k = 0; k < 4; k++) {
            int rr = r + dir[k][0];
            int cc = c + dir[k][1];
            if (cc >= N || cc < 0) continue;
            if (rr >= N || rr < 0) continue;
            if (vis[rr][cc]) continue;
            if (abs(h[rr][cc] - h[r][c]) <= H) {
                vis[rr][cc] = true;
                q.push({rr,cc});
            }
        }
    }
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> N >> H;
    for (int i = 0; i < N; i++) {
        for (int j = 0 ;j < N; j++) {
            cin >> h[i][j];
        }
    }
    //(N-1,N-1)
    bfs(0,0);
    if (vis[N-1][N-1]) {
        cout << "yes" << nl;
    }
    else {
        cout << "no" << nl;
    }
}