class Solution {
    public void helper(int[] arr, int target, int idx, List<List<Integer>> result, List<Integer> ds) {
        if (idx == arr.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            helper(arr, target-arr[idx], idx, result, ds);
            ds.remove(ds.size()-1);
        }
        helper(arr, target, idx+1, result, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(candidates, target, 0, result, ds);
        return result;
    }
}