class Pair{
    String s;
    int l;
    Pair(String s,int l){
        this.s=s;
        this.l=l;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st=new HashSet<>(wordList);
        int len=wordList.size();
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().s;
            int steps=q.peek().l;
            q.remove();
            if(word.equals(endWord)==true){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char rep[]=word.toCharArray();
                    rep[i]=ch;
                    String nw=new String(rep);
                    if(st.contains(nw)==true){
                        st.remove(nw);
                        q.add(new Pair(nw,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
