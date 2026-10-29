class Solution {
    int n, timer;
    List<Integer>[] graph;
    int[] parent, depth, size, heavy, head, pos, seg;
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        graph = new ArrayList[n];
        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        Arrays.fill(heavy, -1);
        int[] order = new int[n];
        int count = 0;
        int[] stack = new int[n];
        int top = 0;
        stack[top++] = 0;
        parent[0] = -1;
        while (top > 0) {
            int u = stack[--top];
            order[count++] = u;
            for (int v : graph[u]) {
                if (v == parent[u]) {
                    continue;
                }
                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }
        for (int i=n-1; i>=0; i--) {
            int u = order[i];
            size[u] = 1;
            int maxSize = 0;
            for (int v : graph[u]) {
                if (parent[v] != u) continue;
                size[u] += size[v];
                if (size[v] > maxSize) {
                    maxSize = size[v];
                    heavy[u] = v;
                }
            }
        }
        timer = 0;
        stack = new int[n];
        int[] chainHeads = new int[n];
        top = 0;
        stack[top++] = 0;
        chainHeads[0] = 0;
        while (top > 0) {
            int u = stack[--top];
            int h = chainHeads[top];
            while (u != -1) {
                head[u] = h;
                pos[u] = timer++;
                for (int v : graph[u]) {
                    if (parent[v] == u && v != heavy[u]) {
                        stack[top] = v;
                        chainHeads[top++] = v;
                    }
                }
                u = heavy[u];
            }
        }
        int[] values = new int[n];
        for (int i=0; i<n; i++) {
            values[pos[i]] = 1 << (s.charAt(i) - 'a');
        }
        seg = new int[4 * n];
        build(1, 0, n - 1, values);
        List<Boolean> results = new ArrayList<>();
        for (String query : queries) {
            String[] p = query.split(" ");
            int u = Integer.parseInt(p[1]);
            if (p[0].equals("update")) {
                int mask = 1 << (p[2].charAt(0) - 'a');
                update(1, 0, n - 1, pos[u], mask);
            } 
            else {
                int v = Integer.parseInt(p[2]);
                int mask = pathQuery(u, v);
                results.add((mask & (mask - 1)) == 0);
            }
        }
        return results;
    }
    void build(int node, int left, int right, int[] values) {
        if (left == right) {
            seg[node] = values[left];
            return;
        }
        int mid = (left + right) / 2;
        build(node * 2, left, mid, values);
        build(node * 2 + 1, mid + 1, right, values);
        seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
    }
    void update(int node, int left, int right, int idx, int value) {
        if (left == right) {
            seg[node] = value;
            return;
        }
        int mid = (left + right) / 2;
        if (idx <= mid) {
            update(node * 2, left, mid, idx, value);
        }
        else {
            update(node * 2 + 1, mid + 1, right, idx, value);
        }
        seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
    }
    int rangeQuery(int node, int left, int right, int ql, int qr) {
        if (ql <= left && right <= qr) {
            return seg[node];
        }
        int mid = (left + right) / 2;
        int result = 0;
        if (ql <= mid) {
            result ^= rangeQuery(node * 2, left, mid, ql, qr);
        }
        if (qr > mid) {
            result ^= rangeQuery(node * 2 + 1, mid + 1, right, ql, qr);
        }
        return result;
    }
    int pathQuery(int u, int v) {
        int mask = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }
            mask ^= rangeQuery(1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        mask ^= rangeQuery(1, 0, n - 1, pos[u], pos[v]);
        return mask;
    }
}