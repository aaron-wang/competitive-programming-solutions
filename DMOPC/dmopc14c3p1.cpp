#include <bits/stdc++.h>
using namespace std;
int a[10];
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int N,K,D; cin >> N >> K >> D;
    for (int i = 1; i <= D; i++) {
        N*=K;
    }
    cout << N << endl;
}