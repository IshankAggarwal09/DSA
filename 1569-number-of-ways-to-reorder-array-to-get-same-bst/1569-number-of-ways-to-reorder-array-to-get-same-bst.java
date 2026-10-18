class Solution {
    static final long MOD = 1_000_000_007L;
    long[][] comb;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new long[n + 1][n + 1];
        for (int i=0; i<=n; i++) {
            comb[i][0] = 1;
            for (int j=1; j<=i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return (int) ((dfs(list) - 1 + MOD) % MOD);
    }
    public long dfs(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i=1; i<nums.size(); i++) {
            int value = nums.get(i);
            if (value < root) {
                left.add(value);
            } 
            else {
                right.add(value);
            }
        }
        long waysLeft = dfs(left);
        long waysRight = dfs(right);
        long interleavings = comb[left.size() + right.size()][left.size()];
        return interleavings * waysLeft % MOD * waysRight % MOD;
    }
}