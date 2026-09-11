class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int ans = 0;

        for (int i = 100; i <= 998; i += 2) {
            int d1 = i / 100, d2 = (i / 10) % 10, d3 = i % 10;        

            int[] currentFreq = new int[10];
            currentFreq[d1]++;
            currentFreq[d2]++;
            currentFreq[d3]++;

            if (currentFreq[d1] <= freq[d1] &&
                currentFreq[d2] <= freq[d2] &&
                currentFreq[d3] <= freq[d3]) {
                ans++;
            }
        }

        return ans;
    }
}