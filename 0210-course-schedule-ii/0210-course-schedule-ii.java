class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        int[] indeg = new int[numCourses];

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indeg[i] == 0) q.add(i);

        int[] order = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            order[idx++] = cur;

            for (int next : adj.get(cur)) {
                if (--indeg[next] == 0)
                    q.add(next);
            }
        }

        return idx == numCourses ? order : new int[0];
    }
}
