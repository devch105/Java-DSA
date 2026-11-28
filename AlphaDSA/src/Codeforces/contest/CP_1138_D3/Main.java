package Codeforces.contest.CP_1138_D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);

            if (a == b)
                return;

            if (size[a] < size[b]) {
                int temp = a;
                a = b;
                b = temp;
            }

            parent[b] = a;
            size[a] += size[b];
        }
    }

    static void solve(Scanner sc) {

        int n = sc.nextInt();
        int m = sc.nextInt();

        int N = 2 * n;

        List<Integer>[] graph = new ArrayList[N];
        List<Integer>[] reverse = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        DSU dsu = new DSU(n);

        for (int i = 0; i < m; i++) {

            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int c = sc.nextInt();

            dsu.union(u, v);

            int fromU = 2 * u + (2 - c);
            int toV = 2 * v + (c - 1);

            int fromV = 2 * v + (2 - c);
            int toU = 2 * u + (c - 1);

            addEdge(graph, reverse, fromU, toV);
            addEdge(graph, reverse, fromV, toU);
        }

        // Kosaraju - First DFS pass
        boolean[] visited = new boolean[N];
        int[] nxt = new int[N];
        int[] order = new int[N];
        int[] st = new int[N];

        int orderSize = 0;

        for (int start = 0; start < N; start++) {

            if (visited[start])
                continue;

            int top = 0;
            st[0] = start;
            visited[start] = true;

            while (top >= 0) {

                int u = st[top];

                if (nxt[u] < graph[u].size()) {

                    int v = graph[u].get(nxt[u]++);

                    if (!visited[v]) {
                        visited[v] = true;
                        st[++top] = v;
                    }

                } else {

                    order[orderSize++] = u;
                    top--;
                }
            }
        }

        int[] comp = new int[N];
        Arrays.fill(comp, -1);

        int[] compSize = new int[N];
        int compCount = 0;

        for (int i = orderSize - 1; i >= 0; i--) {

            int start = order[i];

            if (comp[start] != -1)
                continue;

            int top = 0;
            st[0] = start;

            comp[start] = compCount;
            int count = 0;

            while (top >= 0) {

                int u = st[top--];
                count++;

                for (int v : reverse[u]) {

                    if (comp[v] == -1) {
                        comp[v] = compCount;
                        st[++top] = v;
                    }
                }
            }

            compSize[compCount] = count;
            compCount++;
        }

        boolean[] good = new boolean[n];

        for (int i = 0; i < N; i++) {

            if (compSize[comp[i]] > 1) {

                int originalVertex = i / 2;
                int root = dsu.find(originalVertex);

                good[root] = true;
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {

            if (dsu.find(i) == i && good[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void addEdge(
            List<Integer>[] graph,
            List<Integer>[] reverse,
            int u,
            int v) {
        graph[u].add(v);
        reverse[v].add(u);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            solve(sc);
        }

        sc.close();
    }
}
