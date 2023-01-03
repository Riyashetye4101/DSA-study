#include<bits/stdc++.h>
#include<utility>
using namespace std;

bool punish(int num,int rem){
	if(num==0 && rem==0) return true;
	if((num==0 && rem!=0) || (rem==0 && num!=0)) return false;
	int pow=1;
	while(num>0 && rem>0){
		int digit=num%10;
		rem-=pow*digit;
		num=num/10;

		if(punish(num,rem)) return true;
		pow*=10;
	}
	return false;
}
int main(){
    for(int i=1;i<=10000;i++){
    	if(punish(i*i,i)){
    		cout<<i<<endl;
    	}
    }
    return 0;
    
}
