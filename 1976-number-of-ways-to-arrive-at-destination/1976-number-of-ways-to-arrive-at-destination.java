class Solution {
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int wt = r[2];

            adj.get(u).add(new long[]{v, wt});
            adj.get(v).add(new long[]{u, wt});
        }

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        long[] dist = new long[n];
        int[] ways = new int[n];

        int mod = (int)(1e9 + 7);

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long dis = pq.peek()[0];
            int node = (int)pq.peek()[1];
            pq.remove();

            // Skip outdated entries
            if (dis > dist[node]) continue;

            for (long[] it : adj.get(node)) {

                int adjNode = (int)it[0];
                long ew = it[1];

                if (dis + ew < dist[adjNode]) {

                    dist[adjNode] = dis + ew;

                    pq.add(new long[]{dist[adjNode], adjNode});

                    ways[adjNode] = ways[node];
                }

                else if (dis + ew == dist[adjNode]) {

                    ways[adjNode] =
                            (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}