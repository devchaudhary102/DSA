class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=1;
        }
        int lpro=1;

        for(int i=0;i<nums.length;i++){
            arr[i]*=lpro;
            lpro*=nums[i];
        }
        int rpro=1;
        for(int i=nums.length-1;i>=0;i--){
            arr[i]*=rpro;
            rpro*=nums[i];
        }
        return arr;
    }
}