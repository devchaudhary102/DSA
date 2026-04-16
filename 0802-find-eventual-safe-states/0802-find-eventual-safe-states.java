class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adjr=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjr.add(new ArrayList<>());
        }
        int[] ind=new int[n];
        for(int i=0;i<n;i++){
            for(int it:graph[i]){
                adjr.get(it).add(i);
                ind[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> sf=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            sf.add(node);
            for(int it:adjr.get(node)){
                ind[it]--;
                if(ind[it]==0) q.add(it);
            }
        }
        Collections.sort(sf);
        return sf;
    }
}