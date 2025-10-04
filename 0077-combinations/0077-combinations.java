class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int ar[]=new int[n];
        for(int i=0;i<n;i++){
            ar[i]=i+1;
        }
        List<List<Integer>> ls=new ArrayList<>();
        List<Integer> al=new ArrayList<>();
        pair(n,k,ls,al,0,ar);
        return ls;

    }
    void pair(int n,int k,List<List<Integer>> ls,List<Integer> al,int ind,int ar[]){
        if(al.size()==k){
            ls.add(new ArrayList<>(al));
            return;
        }
        for(int i=ind;i<ar.length;i++){
            al.add(ar[i]);
            pair(n,k,ls,al,i+1,ar);
            al.remove(al.size()-1);
        }
    }
}