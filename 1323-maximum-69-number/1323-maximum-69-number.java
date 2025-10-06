class Solution {
    public int maximum69Number (int num) {
        int len = (int) Math.log10(num) + 1;
        int digit[]=new int[len];
        for(int i=len-1;i>=0;i--){
            digit[i]=num%10;
            num/=10;
        }
        for(int i=0;i<len;i++){
            if(digit[i]==6){
                digit[i]=9;
                break;
            }
        }
        int ans=0;
        for(int i=0;i<len;i++){
            ans=ans*10+digit[i];
        }
        return ans;
    }
}