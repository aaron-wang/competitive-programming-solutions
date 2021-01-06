#include <bits/stdc++.h>
using namespace std;
double tilt = 0;
int main() {
    // cin.sync_with_stdio(false); cin.tie(0);
    int N; cin >> N;
    for (int i =0; i < N; i++) {
        double x; cin >> x;
        tilt += x;
        tilt -= 360.0 * ((long long) (tilt/360.0));
    }
    // tilt -= 360 * (long) (tilt/360.0);
    printf("%.5f",tilt);
}