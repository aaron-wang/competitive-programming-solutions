#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<int,int> pi;
const int MM = 53;
bool vis[MM][MM];
int C,R, d[MM][MM], dir[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
pi startp, endp;
void bfs(int a, int b) {
    queue<pi> q;
    q.push({a,b});
    vis[a][b] = true;
    d[a][b] = 0;
    while (!q.empty()) {
        int r = q.front().first;
        int c = q.front().second; q.pop();
        for (int k = 0; k < 4; k++) {
            int RR = r + dir[k][0];
            int CC = c + dir[k][1];
            if (RR < 0 || RR >= R) continue;
            if (CC < 0 || CC >= C) continue;
            if (vis[RR][CC]) continue;
            vis[RR][CC] = true;
            d[RR][CC] = d[r][c] + 1;
            q.push({RR,CC});
        }
    }
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int T; cin >> T;
    while(T--) {
        //init
        cin >> C >> R;
        memset(vis,false,sizeof(vis));
        for (int i = 0; i < MM; i++) {
            for (int j = 0; j < MM; j++) {
                d[i][j] = 1e9;
            }
        }
        for (int i = 0; i < R; i++) {
            string s; cin >> s;
            for (int j = 0; j < C; j++) {
                char c = s.at(j);
                if (c == 'O') vis[i][j] = false;
                else if (c == 'X') vis[i][j] = true;
                else if (c == 'C') startp = {i,j};
                else if (c == 'W') endp = {i,j};
                else;
            }
        }
        bfs(startp.first,startp.second);
        if (d[endp.first][endp.second] >= 60) {
            cout << "#notworth\n";
        }
        else {
            cout << d[endp.first][endp.second] << '\n';
        }
    }
}