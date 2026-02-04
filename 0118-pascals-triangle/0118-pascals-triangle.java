class Solution {
    public List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int col=1; col<row; col++) {
            ans = ans * (row-col);
            ans = ans / col;
            list.add((int)ans);
        }
        return list;
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