class Pair{
    int first;
    int sec;
    Pair(int first,int sec){
        this.first=first;
        this.sec=sec;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0||j==m-1||i==n-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int delr[]={-1,0,1,0};
        int delc[]={0,-1,0,1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().sec;
            q.remove();
            for(int i=0;i<4;i++){
                int nr=row+delr[i];
                int nc=col+delc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]==0){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
            

        }
        int count=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1 && vis[i][j]==0){
                        count++;
                    }
                }
            }
            return count;
    }
}