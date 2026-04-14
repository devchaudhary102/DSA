class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs=new HashSet<>(wordDict);
        Boolean dp[]=new Boolean[s.length()];
        boolean res=helper(s,hs,0,dp);
        return res;
    }
    public boolean helper(String s,HashSet<String> hs,int sin,Boolean dp[]){
        if(sin==s.length()) return true;
        if(dp[sin]!=null) return dp[sin];
        for(int i=sin+1;i<=s.length();i++){
            String str=s.substring(sin,i);
            if(hs.contains(str)){
                if(helper(s,hs,i,dp)) return dp[sin]=true;
            }
        }
        return dp[sin]=false;
    }
}