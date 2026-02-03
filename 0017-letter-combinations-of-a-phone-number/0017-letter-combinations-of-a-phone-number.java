class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        Map<Character, String> phoneMap = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        return helper(digits, phoneMap, 0, "");
    }
    private List<String> helper(String digits, Map<Character, String> phoneMap, int index, String path) {
        if (index == digits.length()) {
            return List.of(path); 
        }
        List<String> combinations = new ArrayList<>();
        String letters = phoneMap.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            combinations.addAll(helper(digits, phoneMap, index + 1, path + letter));
        }
        return combinations;
    }
}