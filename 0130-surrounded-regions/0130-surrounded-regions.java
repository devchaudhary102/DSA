class Solution {
    private void dfs(int r ,int c,int vis[][],char[][] board,int[] delr,int delc[]){
        int n=board.length;
        int m=board[0].length;
        vis[r][c]=1;
        for(int i=0;i<4;i++){
            int nr=r+delr[i];
            int nc=c+delc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && board[nr][nc]=='O'){
                dfs(nr,nc,vis,board,delr,delc);
            } 
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int delr[]={-1,0,1,0};
        int delc[]={0,1,0,-1};
        int vis[][]=new int[n][m];
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,vis,board,delr,delc);
            }
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,vis,board,delr,delc);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,vis,board,delr,delc);
            }
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,vis,board,delr,delc);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
}