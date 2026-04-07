class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n=commands.length;
        int m=obstacles.length;

        Set<String> s=new HashSet<>();
        for(int i=0;i<m;i++){
            s.add(obstacles[i][0]+" "+obstacles[i][1]);
        }
        int row[]={0,1,0,-1};
        int col[]={1,0,-1,0};

        int x=0;
        int y=0;
        int d=0;
        int max=0;
        for(int i=0;i<n;i++){

            int com=commands[i];
            if(com==-2) d=(d+3)%4;
            else if(com==-1) d=(d+1)%4;
            else{
                while(com-->0){
                    int xy=x+row[d];
                    int yx=y+col[d];

                    if(s.contains(xy+" "+yx)) break;
                    
                    x=xy;
                    y=yx;
                }
                max=Math.max((x*x)+(y*y),max);
            }
        }
        return max;
    }
}