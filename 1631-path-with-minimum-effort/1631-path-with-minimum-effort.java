class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y) -> x[1]-y[1]);
        int n=heights.length;
        int m=heights[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        pq.add(new int[]{0,0,0});
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(pq.size()!=0){
            int it[]=pq.peek();
            pq.remove();
            int diff=it[1];
            int row=it[0];
            int col=it[2];
            if(row==n-1&&col==m-1) return diff;
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m){
                    int ne=Math.max(Math.abs(heights[row][col]-heights[nr][nc]),diff);
                    if(ne<dist[nr][nc]){
                        dist[nr][nc]=ne;
                        pq.add(new int[]{nr,ne,nc});
                    }
                }
            }
        }
        return 0;

    }
}