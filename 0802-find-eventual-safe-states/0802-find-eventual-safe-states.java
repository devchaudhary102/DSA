class Solution {
    private boolean dfs(int node,int[][] graph,int vis[],int pvis[],int check[]){
        vis[node]=1;
        pvis[node]=1;
        check[node]=0;
        for(int it:graph[node]){
            if(vis[it]==0){
                if(dfs(it,graph,vis,pvis,check)==true) return true;
            }
            else if(pvis[it]==1){
                return true;
            }
        }
        check[node]=1;
        pvis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int vis[]=new int[n];
        int pvis[]=new int[n];
        int check[]=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,pvis,check);
            }
        }
        List<Integer> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1){
                al.add(i);
            }
        }
        return al;

    }
}
