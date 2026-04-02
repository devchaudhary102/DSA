class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) rev.add(new ArrayList<>());

        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            out[i] = graph[i].length;
            for (int v : graph[i])
                rev.get(v).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (out[i] == 0) q.add(i);

        boolean[] safe = new boolean[n];

        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int prev : rev.get(node)) {
                if (--out[prev] == 0)
                    q.add(prev);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (safe[i]) res.add(i);

        return res;
    }
}
