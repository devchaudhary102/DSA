class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = 1;

        for (String word : words) {
            int best = 1;
            for (int i = 0; i < word.length(); i++) {
                String pred = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(pred, 0) + 1);
            }
            dp.put(word, best);
            ans = Math.max(ans, best);
        }

        return ans;
    }
}
