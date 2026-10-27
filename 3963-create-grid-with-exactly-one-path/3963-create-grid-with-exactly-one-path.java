class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m-1; i++){
            sb.setLength(0);
            sb.append('.');
            for(int j=0; j<n-1; j++){
                sb.append('#');
            }
            ans[i] = sb.toString();
        }
        sb.setLength(0);
        for(int i=0; i<n; i++){
            sb.append('.');
        }
        ans[m-1] = sb.toString();
        return ans;
    }
}