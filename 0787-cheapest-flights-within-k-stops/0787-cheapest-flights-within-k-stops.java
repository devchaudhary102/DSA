class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,src,0});
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)(1e9);
        }
        dist[src]=0;
        while(!q.isEmpty()){
            int it[]=q.peek();
            q.remove();
            int stops=it[0];
            int node=it[1];
            int cost=it[2];
            if(stops>k) continue;
            for(int[] iter:adj.get(node)){
                int adjn=iter[0];
                int ew=iter[1];
                if(cost+ew<dist[adjn] &&stops<=k){
                    dist[adjn]=cost+ew;
                    q.add(new int[]{stops+1,adjn,cost+ew});
                }
            }
        }
        if(dist[dst]==(int)(1e9)) return -1;
        return dist[dst];
    }
}