 #include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n';
const int MM = 660;
const int TM = 650;
const int MP = 5e5+5;
int pre[MM][MM], aa[MM][MM];
pair<int,int> points[MP];

int sum(int x,int y, int x2, int y2) {
    return pre[x2][y2] - pre[x-1][y2] - pre[x2][y-1] + pre[x-1][y-1];
}
int main() {
    // freopen("in.txt","r",stdin);
    // freopen("out.txt","w",stdout);
    cin.sync_with_stdio(false); cin.tie(0);
    int N; cin >> N;
    for (int i = 1; i <= N; i++) {
        int a,b;
        cin >> a >> b;
        ++a;++b;
        points[i] = {a,b};
        aa[a][b]+= 1;
    }
    //standard 2d
    for (int i = 1; i <= MM; i++) {
        for (int j = 1; j <= MM; j++) {
            pre[i][j] = aa[i][j]+ pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
        }
    }
    int hi, lo;
    for (int i = 1; i <= N; i++) {
        int A = points[i].first; int B = points[i].second;
        //ahead
        hi = sum(A+1,B+1,TM+1,TM+1);
        //behind
        lo = N;
        lo -= sum(1,1,A-1,B-1);
        ++hi;
        if (B == TM+1) lo -= aa[A][1];
        if (A == TM+1) lo -= aa[1][B];
        cout << hi << " " << lo << nl;
    }
}