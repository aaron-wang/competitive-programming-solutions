#include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n'; 
const int MM = 26;
int R,C;
int dir[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
vector<int> rsizes;
bool vis[MM][MM];
queue<pair<int,int>> q;
void bfs(int a,int b) {
    q.push({a,b});
    int cnt = 0;
    vis[a][b] = true;
    while (!q.empty()) {
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        cnt++;
        for (int k = 0; k < 4; k++) {
            int rr = r+ dir[k][0];
            int cc = c+ dir[k][1];
            if (rr < 0 || rr >= R) continue; if (cc < 0 || cc >= C) continue;
            if (vis[rr][cc]) continue;
            vis[rr][cc] = true;
            q.push({rr,cc});
        }
    }
    if (cnt != 0) {
        rsizes.push_back(-cnt);
    }
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int wood; cin >> wood;
    cin>>R>>C;

    for (int i = 0; i < R; i++) {
        string row;
        cin>>row;
        for (int j = 0; j < C; j++) {
            if (row.at(j)== 'I') {
                vis[i][j] = true;
            }
            else {
                vis[i][j] = false;
            }
        }
    }
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (!vis[i][j]) bfs(i,j);
        }
    }
    sort(rsizes.begin(),rsizes.end());
    int rooms = 0;
    for (int i = 0; i < rsizes.size(); i++) {
        int here = -rsizes[i];
        if (wood - here < 0) {
            break;
        }
        else {
            wood-= here;
            rooms++;
        }
    }
    if (rooms == 1) {
    cout << rooms << " room, " << wood << " square metre(s) left over" << nl;
    }
    else {
cout << rooms << " rooms, " << wood << " square metre(s) left over" << nl;
    }
}