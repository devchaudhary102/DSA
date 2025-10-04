class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls=new ArrayList<>();
        List<Integer> al=new ArrayList<>();
        set(ls,al,nums,0);
        return ls;
    }
    void set(List<List<Integer>> ls,List<Integer> al,int nums[],int ind){
        if(ind==nums.length){
            ls.add(new ArrayList<>(al));
            return ;
        }

        al.add(nums[ind]);
        set(ls,al,nums,ind+1);

        al.remove(al.size()-1);
        set(ls,al,nums,ind+1);
    }
}