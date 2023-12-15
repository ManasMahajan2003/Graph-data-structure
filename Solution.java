import java.util.*;
class Solution {
    static int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int freshcount=0;
        int minutes=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    freshcount++;
                }
            }
        }
        q.offer(null);
        int[][] directions={{0,1}, {0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            
            
            
                int[] curr=q.poll();
                if(curr==null){
                    if(!q.isEmpty()){
                        q.offer(null);
                        minutes++;
                    }
                }else{
                for(int[] dir: directions){
                int newrow=curr[0]+ dir[0];
                int newcol=curr[1]+ dir[1];
                    if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols && grid[newrow][newcol]==1){
                        grid[newrow][newcol]=2;
                        q.offer(new int[]{newrow,newcol});
                        freshcount--;
                        
                    }
                }
            }
            
        }
        return freshcount==0 ? minutes:-1;
    }

    public static void main(String args[]){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
