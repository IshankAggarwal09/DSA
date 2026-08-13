class Solution {

    char[] s;
    int size;
    char[] first;
    char[] last;
    int[] pre; 
    int[] suf; 
    int[] best; 
    int[] len;

    public int[] longestRepeating(String str, String queryCharacters, int[] queryIndices) {
        s = str.toCharArray();
        int n = s.length;
        size = 1;
        while (size < n) {
            size <<= 1;
        }
        int total = size << 1;
        first = new char[total];
        last = new char[total];
        pre = new int[total];
        suf = new int[total];
        best = new int[total];
        len = new int[total];
        for (int i=0; i<n; i++) {
            int p = size + i;
            first[p] = last[p] = s[i];
            pre[p] = suf[p] = best[p] = len[p] = 1;
        }
        for (int i=size-1; i>0; i--) {
            merge(i, i << 1, i << 1 | 1);
        }
        int[] ans = new int[queryIndices.length];
        for (int q=0; q<queryIndices.length; q++) {
            int pos = size + queryIndices[q];
            char c = queryCharacters.charAt(q);
            first[pos] = last[pos] = c;
            pre[pos] = suf[pos] = best[pos] = len[pos] = 1;
            pos >>= 1;
            while (pos > 0) {
                merge(pos, pos << 1, pos << 1 | 1);
                pos >>= 1;
            }
            ans[q] = best[1];
        }
        return ans;
    }
    public void merge(int p, int l, int r) {
        first[p] = first[l];
        last[p] = last[r];
        len[p] = len[l] + len[r];
        pre[p] = pre[l];
        suf[p] = suf[r];
        best[p] = Math.max(best[l], best[r]);
        if (last[l] == first[r]) {
            int join = suf[l] + pre[r];
            if (join > best[p]) {
                best[p] = join;
            }
            if (pre[l] == len[l]) {
                pre[p] = len[l] + pre[r];
            }
            if (suf[r] == len[r]) {
                suf[p] = suf[l] + len[r];
            }
        }
    }
}