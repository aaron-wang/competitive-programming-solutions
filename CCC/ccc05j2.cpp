#include <bits/stdc++.h>

using namespace std;

int main() {
    //range start and end INCLUSIVE

    int start, end, count = 0;
    cin.tie(0);
    cin.sync_with_stdio(0);

    cin >> start;

    cin >> end;

    for (int i = start; i <= end; i++) {
        int divCount = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) divCount++;
            if (divCount > 4) {
                break;
            }
        }
        if (divCount == 4) {
            count++;
        }
    }

    printf("The number of RSA numbers between %d and %d is %d",start,end,count);
}