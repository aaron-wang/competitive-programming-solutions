#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0);
    cin.sync_with_stdio(0);

    int m, n;

    cin >> m;

    cin >> n;

    int maxim = max(m,n);
    int minim = min(m,n);

    if (maxim > 10) {
        maxim = 10;
    }

    int count = 0;

    for (int i = maxim; i > 0; i--) {
        for (int j = 1; j <= minim; j++) {
            if (i + j == 10) {
                count++;
            }
        }
    }
    if (count == 1) {
        printf("There is %d way to get the sum 10.",count);
    }
    else {
        printf("There are %d ways to get the sum 10.",count);
    }
}