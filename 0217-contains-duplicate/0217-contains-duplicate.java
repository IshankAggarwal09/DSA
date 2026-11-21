class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Set contain only unique elements (Property of HashSet)
        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {

            // If the set already contains the current number then duplicate is found
            if (!set.add(num)) {
                return true;
            }
        }

        //Otherwise, no duplicate is found
        return false;
    }
}