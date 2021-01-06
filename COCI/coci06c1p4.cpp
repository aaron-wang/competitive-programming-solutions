#include <bits/stdc++.h>
#define pb push_back
#define f first
#define s second
using namespace std;
using pi = pair<int,int>; using vi = vector<int>;
using ll = long long; constexpr char nl = '\n'; 
const int MM = 51;
int R,C, dir[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
bool vis[MM][MM];
int df[MM][MM], pd[MM][MM];
char field[MM][MM];
void bfsFlood(int a, int b) {
    for (int i = 0; i < MM; i++) {
        for (int j = 0; j < MM; j++) vis[i][j] = false;
    }
    queue<pi> q;
    q.push({a,b});
    df[a][b] = 0;
    vis[a][b] = true;
    while (!q.empty()) {
        int r = q.front().f; int c = q.front().s;
        q.pop();
        for (int k = 0; k < 4; k++) {
            int rr = r + dir[k][0];
            int cc = c+ dir[k][1];
            if (rr < 0 || rr >= R) continue;
            if (cc < 0 || cc >= C) continue;
            if (field[rr][cc] == 'X') continue;
            if (field[rr][cc] == 'D') continue;
            if (vis[rr][cc]) continue;
            vis[rr][cc] = true;
            if (df[r][c] + 1 < df[rr][cc]) {
                df[rr][cc] = df[r][c]+1;
                q.push({rr,cc});
            }
        }
    }
}
void bfsPaint(int a,int b) {
    for (int i = 0; i < MM; i++) {
        for (int j = 0; j < MM; j++) vis[i][j] = false;
    }
    queue<pi> q;
    q.push({a,b});
    pd[a][b] = 0;
    vis[a][b] = true;
    while (!q.empty()) {
        int r = q.front().f; int c = q.front().s;
        q.pop();
        for (int k = 0; k < 4; k++) {
            int rr = r + dir[k][0];
            int cc = c+ dir[k][1];
            if (rr < 0 || rr >= R) continue;
            if (cc < 0 || cc >= C) continue;
            if (field[rr][cc] == 'X') continue;
            if (vis[rr][cc]) continue;
            vis[rr][cc] = true;
            if (df[rr][cc] <= pd[r][c] +1 && field[rr][cc] != 'D') continue;

            pd[rr][cc] = pd[r][c] + 1;
            q.push({rr,cc});
        }
    }
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> R >> C;
    vector<pi> org;
    pi S, E;
    for (int i = 0; i < R; i++) {
        string str; cin >> str;
        for (int j = 0; j < C; j++) {
            df[i][j] = 10000; pd[i][j] = 10000;
            char op = str.at(j);
            field[i][j] = op;
            if (op == 'D') {
                E = {i,j};
            }
            else if (op == 'S') {
                S = {i,j};
            }
            else if (op == 'X') {
                //not needed
            }
            else if (op == '*') {
                org.pb({i,j});
            }
            else {
                //nothing
            }
        }
    }
    for (auto u: org) {
        bfsFlood(u.f,u.s);
    }

    bfsPaint(S.f,S.s);
    if (!vis[E.f][E.s]) {
        cout << "KAKTUS" << nl;
    }
    else {
        cout << pd[E.f][E.s] << nl;
    }
    // for (int i = 0; i < R; i++) {
    //     for (int j = 0; j < C; j++) {
    //         cout << df[i][j] <<  "\t";
    //     }
    //     cout <<nl;
    // }
    // for (int i = 0; i < R; i++) {
    //     for (int j = 0; j < C; j++) {
    //         cout << pd[i][j] <<  "\t";
    //     }
    //     cout <<nl;
    // }

}