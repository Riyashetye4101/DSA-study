#include<bits/stdc++.h>
using namespace std;


void printNSE(int arr[], int n)
{
    stack<pair<int, int> > s;
    vector<int> ans(n);
 
    for (int i = 0; i < n; i++) {
        int next = arr[i];
 
        if (s.empty()) {
            s.push({ next, i });
            continue;
        }
 
        while (!s.empty() && s.top().first > next) {
            ans[s.top().second] = next;
            s.pop();
        }
 
 
        s.push({ next, i });
    }
 
 
    while (!s.empty()) {
        ans[s.top().second] = -1;
        s.pop();
    }
 
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ---> " << ans[i] << endl;
    }
}
/*
11 ---> 3
13 ---> 3
21 ---> 3
3 ---> -1

*/

void printPrevSmaller(int arr[], int n)
{
    
    stack<int> S;
    for (int i=0; i<n; i++)
    {
        while (!S.empty() && S.top() >= arr[i])
            S.pop();
 
        
        if (S.empty())
            cout << "_, ";
        else  
            cout << S.top() << ", ";
 
        S.push(arr[i]);
    }
}
 


void printNGE(int arr[], int n)
{
    stack<int> s;
    s.push(arr[0]);
 
    for (int i = 1; i < n; i++) {
 
        if (s.empty()) {
            s.push(arr[i]);
            continue;
        }
 
        while (s.empty() == false && s.top() < arr[i]) {
            cout << s.top() << " --> " << arr[i] << endl;
            s.pop();
        }
 
        s.push(arr[i]);
    }
 
    while (s.empty() == false) {
        cout << s.top() << " --> " << -1 << endl;
        s.pop();
    }
}

void prevGreater(int arr[], int n)
{
    
    stack<int> s;
    s.push(arr[0]);
     
    
    cout << "-1, ";
 
   
    for (int i = 1; i < n; i++) {

        while (s.empty() == false && s.top() < arr[i])
            s.pop();
 
        s.empty() ? cout << "-1, " : cout << s.top() << ", ";
 
        s.push(arr[i]);
    }
}


int main(){
	int a;
	cin>>a;
	cout<<a;
	return 0;
}