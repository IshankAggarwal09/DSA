class Solution {
    public List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int col=1; col<row; col++) {
            ans = ans * (row-col);
            ans = ans / col;
            res.add((int)ans);
        }
        return res;
    }
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            ans.add(generateRow(i));
        }
        return ans;
    }
}