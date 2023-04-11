// This code studies all possible possibilities and presents the best possible And minimum moves 
#include<bits/stdc++.h>
#define endl "\n"
#define pb push_back
using namespace std; // Specify Language Standard Version
vector<int> clocksMain(9);  // define nine clock's 
void input(){              // function take input from user 
    for(int i=0;i<9;i++){
        cin>>clocksMain[i];
    }
}
// define all moves and it's affected clock's A-1    B-2    C-3    D-4    E-5    F-6    G-7    H-8    I-9 
//move 1 ABDE 1245
//move 2 ABC  123
//move 3 BCEF 2356
//move 4 ADG  147
//move 5 BDEFH 24568
//move 6 CFI   369
//move 7 DEGH  4578
//move 8 GHI   789
//move 9 EFHI  5689
vector<int> bt1={1,2,4,5},bt2={1,2,3},bt3={2,3,5,6},bt4={1,4,7},bt5={2,4,5,6,8},
bt6={3,6,9},bt7={4,5,7,8},bt8={7,8,9},bt9={5,6,8,9};
void move(int btn,vector<int> &clocks){ 
    if(btn==1)for(int i=0;i<bt1.size();i++)clocks[bt1[i]-1]++;      
    if(btn==2)for(int i=0;i<bt2.size();i++)clocks[bt2[i]-1]++;
    if(btn==3)for(int i=0;i<bt3.size();i++)clocks[bt3[i]-1]++;
    if(btn==4)for(int i=0;i<bt4.size();i++)clocks[bt4[i]-1]++;
    if(btn==5)for(int i=0;i<bt5.size();i++)clocks[bt5[i]-1]++;
    if(btn==6)for(int i=0;i<bt6.size();i++)clocks[bt6[i]-1]++;
    if(btn==7)for(int i=0;i<bt7.size();i++)clocks[bt7[i]-1]++;
    if(btn==8)for(int i=0;i<bt8.size();i++)clocks[bt8[i]-1]++;
    if(btn==9)for(int i=0;i<bt9.size();i++)clocks[bt9[i]-1]++;
    for(int i=0;i<clocks.size();i++)clocks[i]%=4;
    return;
}
//this function checks if all clock's in 0 or 12 clock or not , we will use it later 
bool check(vector<int>clocks){ 
    for(int i=0;i<9;i++){
        if(clocks[i]==0)continue;
        return false;
    }
    return true;
}
vector<string> pos,ans,ansP;  // pos : Possibilities , ans : answer sequential , ans: answer parallel 
void generateSolutions(int n,string cur){ // this function generate all solutions 
    if(n==0)pos.pb(cur);
    else{
        for(char i='0';i<'4';i++){
            generateSolutions(n-1,cur+i);
        }
    }
}

int posParrallel=0; //begin Possibilities parallel = 0
//I moved on all the possibilities,and let move the clocks,each one of them after that.
//If reached an answer,would put this output in the answer.
void solve(){       // this is sequential code for the problem 
    for(int i=0;i<pos.size();i++){
        vector<int>clocksNow(clocksMain.begin(),clocksMain.end());
        for(int j=0;j<pos[i].size();j++){
            for(int k=0;k<pos[i][j]-'0';k++){
                move(j+1,clocksNow);
            }
        }
        if(check(clocksNow))ans.pb(pos[i]);
    }
    // this is parallel code for the problem 
    //I moved on all the possibilities,and let move the clocks,each one of them after that.
   //If reached an answer,would put this output in the answer. but we divided into 3 processors 
    int sz=pos.size()/3;                     // here u will divide on 3 processors proc1 , proc2 , proc3
    vector<string> proc1(pos.begin(),pos.begin()+sz),proc2(pos.begin()+sz,pos.begin()+2*sz),
    proc3(pos.begin()+2*sz,pos.end());
    vector<vector<string>>processors={proc1,proc2,proc3};

    for(vector<string> p:processors){
        for(int i=0;i<p.size();i++){    //this loop moves the processors 
            posParrallel=max(posParrallel,(int)p.size());   //find max number of posabilities 
            vector<int>clocksNow(clocksMain.begin(),clocksMain.end());
            for(int j=0;j<p[i].size();j++){
                for(int k=0;k<p[i][j]-'0';k++){
                    move(j+1,clocksNow);      }
            }
            if(check(clocksNow))ansP.pb(p[i]);
    }   }

}
void print(){    // print mimimum moves of sequential and possiblities 
    sort(ans.begin(),ans.end());
    cout<<"number of Possibilities : "<<pos.size()<<endl;
    int c=0;
    for(int i = 0;i<ans[0].size();i++){
        if(ans[0][i]=='0')continue;
        c++;
        cout<<" move  "<<i+1<<" compressed in "<<ans[0][i]<<" times"<<endl;  }
    cout<<"Minimum number of moves: "<<c<<endl; }
    
void printParallel(){   // print minimum moves of parallel and possiblities 
    sort(ansP.begin(),ansP.end());
    cout<<"number of Possibilities : "<<posParrallel<<endl;
    int c=0;
    for(int i = 0;i<ansP[0].size();i++){
        if(ansP[0][i]=='0')continue;
        c++;
        cout<<"move  "<<i+1<<" compressed in  "<<ansP[0][i]<<" times"<<endl; }
    cout<<"Minimum number of moves: "<<c<<endl; }
    //this is main function 
int32_t main(){
    cout<<"SEQ output"<<endl<<endl; 
    input();
    generateSolutions(9,"");
    solve();
    print();
    cout<<endl;
    cout<<"PAR output"<<endl<<endl;
    printParallel();
    return 0;
}