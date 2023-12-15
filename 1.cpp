//Warshall algorithm
#include<iostream>
using namespace std;
int main(){
    
    int a[4][4]={{0,0,0,1},{1,0,1,1},{1,0,0,1},{0,0,1,0}};
    int p[4][4];
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            if (a[i][j]==0)
            {
                p[i][j]=0;
            }
            else{
                p[i][j]=1;
            }
        }
        
    }
    for (int k = 0; k < 4; k++)
    {
        
    
    
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            p[i][j]=p[i][j]||(p[i][k]&&p[k][j]);
        }
        
    }
    }
    for (int i = 0; i < 4; i++)
    {
         for (int j= 0; j < 4; j++)
         {
            cout<<p[i][j]<<" ";
         }
         cout<<endl;
    }
    
    return 0;
}