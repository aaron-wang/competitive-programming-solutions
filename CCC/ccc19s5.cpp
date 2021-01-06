#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3002;
int tr[MAXN][MAXN];
int org[MAXN][MAXN];
	
void update(int r, int c, int val) {
    for (int i = r; i <= MAXN; i+=(i&-i)) {
        for (int j = c; j <= MAXN; j += (j&-j)) {
//				if (tr[i][j] == 0) continue;
            tr[i][j] = max(tr[i][j],val);
        }
    }
}
	
int mx(int r, int c) {
    int ret = 0;
    for (int i = r; i >0; i-=(i&-i)) {
        for (int j = c; j >0; j -= (j&-j)) {				
            ret = max(ret,tr[i][j]);
        }
    }
    return ret;
}
int main() {
    cin.tie(0);
    cin.sync_with_stdio(false);
    int N, K;
    cin >> N >> K;
    //align
    for (int i = 1; i <= N; i++) {
        for (int j = i; j >= 1; j--) {
            cin >> org[i][N-j+1];
        }
    }
    long ans = 0;
    for (int d = 0; d < N; d++) {
        for (int r = 0; r <= d; r++) {
            int R = N - d+r;
            update(R,N-r,org[R][N-r]);
        }
        for (int i = 0; i<= d-K+1; i++) {
            ans += mx(N-d+K-1+i,N-i);
        }
    }
    cout<< ans << "\n";
}