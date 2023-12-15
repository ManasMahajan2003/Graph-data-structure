//Shortest path algorithm
#include<iostream>
using namespace std;
int main(){
    int w[4][4]={{7,5,0,0},{7,0,0,2},{0,3,0,0},{4,0,1,0}};
    int q[4][4];
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            if (w[i][j]==0)
            {
                q[i][j]=INT16_MAX;
            }
            else{
                q[i][j]=w[i][j];
            }
        }
        
    }
    for (int k = 0; k < 4; k++)
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                q[i][j]=min(q[i][j],q[i][k]+q[k][j]);
            }
            
        }
        
    }
    for (int i = 0; i <4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            cout<<q[i][j]<<" ";
        }
        cout<<endl;
    }
    

    return 0;
}