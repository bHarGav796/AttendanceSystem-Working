//Hashmap
#include<iostream>
#include<map>
#include<unordered_map>
using namespace std;

int main(){
    //creation
    unordered_map<string,int> m;

    //insertion
    m["shukanya"]=1;
    m["bhargav"]=2;

    //Searching
    cout<<m["bhargav"]<<endl;

    //size check
    cout<<m.size()<<endl;

    //check present
    cout<<m.count("bhargav")<<endl;
    //erase
    m.erase("");

    for(auto i:m){
        cout<<i.first<<" "<<i.second<<" "<<endl;
    }
    return 0;
}

