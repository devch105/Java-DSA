package Graph.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P_207 {
    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };

        P_207 obj = new P_207();
        boolean canFinish = obj.canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + canFinish);
    }

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Edge>[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build adjacency list
        for (int[] p : prerequisites) {

            int src = p[1];
            int dest = p[0];

            adj[src].add(new Edge(src, dest));
        }

        return topologicalSort(adj);
    }

    public boolean topologicalSort(ArrayList<Edge>[] graph) {

        int v = graph.length;

        int[] inDeg = new int[v];

        // Calculate indegree
        for (int i = 0; i < v; i++) {

            for (Edge e : graph[i]) {
                inDeg[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add vertices having indegree 0
        for (int i = 0; i < v; i++) {

            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {

            int curr = q.remove();

            count++;

            for (Edge e : graph[curr]) {

                inDeg[e.dest]--;

                if (inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        return count == v;
    }
}
