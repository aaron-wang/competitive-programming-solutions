#include <iostream>
using namespace std;

int main() 
{
	int currentYear, maxYear;
	cin >> currentYear;
	cin >> maxYear;
	for (int i = 0; i <= maxYear - currentYear; i++) {
		if (i % 60 == 0) {
			cout << "All positions change in year " << currentYear + i << endl;
		}
	}
}