class Solution {
    public void helper(int start,int[] candidates,List<List<Integer>> ls,List<Integer> ds,int target)
    {
        if(target<0){
            return ;
        }
        if(target==0)
        {
            ls.add(new ArrayList<>(ds));
            return;
        }
        for(int i=start;i<candidates.length;i++)
        {
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            ds.add(candidates[i]);
            helper(i+1,candidates,ls,ds,target-candidates[i]);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ls=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        helper(0,candidates,ls,ds,target);
        return ls; 
    }
}