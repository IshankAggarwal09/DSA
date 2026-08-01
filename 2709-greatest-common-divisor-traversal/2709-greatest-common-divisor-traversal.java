class Solution {
    Map<Integer, List<Integer>> prime2index = new HashMap<>();
    Map<Integer, List<Integer>> index2prime = new HashMap<>();
    public void dfs(int index, boolean[] visitedIndex, Map<Integer, Boolean> visitedPrime) {
        if (visitedIndex[index]) {
            return;
        }
        visitedIndex[index] = true;
        for (int prime : index2prime.getOrDefault(index, Collections.emptyList())) {
            if (visitedPrime.getOrDefault(prime, false)) {
                continue;
            }
            visitedPrime.put(prime, true);
            for (int next : prime2index.getOrDefault(prime, Collections.emptyList())) {
                if (!visitedIndex[next]) {
                    dfs(next, visitedIndex, visitedPrime);
                }
            }
        }
    }
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int num : nums) {
            if (num == 1) {
                return false;
            }
        }
        for (int i=0; i<nums.length; i++) {
            int temp = nums[i];
            for (int j=2; j*j<=temp; j++) {
                if (temp % j == 0) {
                    prime2index.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                    index2prime.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    while (temp % j == 0) {
                        temp /= j;
                    }
                }
            }
            if (temp > 1) {
                prime2index.computeIfAbsent(temp, k -> new ArrayList<>()).add(i);
                index2prime.computeIfAbsent(i, k -> new ArrayList<>()).add(temp);
            }
        }
        boolean[] visitedIndex = new boolean[nums.length];
        Map<Integer, Boolean> visitedPrime = new HashMap<>();
        dfs(0, visitedIndex, visitedPrime);
        for (boolean b : visitedIndex) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}