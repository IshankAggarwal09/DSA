class Solution {
    public void helper(int[] arr, int target, List<List<Integer>> ans, int idx, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i=idx; i<arr.length; i++) {
            if (i > idx && (arr[i] == arr[i-1])) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            ds.add(arr[i]);
            helper(arr, target-arr[i], ans, i+1, ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, ans, 0, ds);
        return ans;
    }
}