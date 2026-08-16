class Solution {
    public String largestMerge(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                ans.append(word1.charAt(i));
                i++;
            }
            else {
                ans.append(word2.charAt(j));
                j++;
            }
        }
        while (i < word1.length()) {
            ans.append(word1.charAt(i));
            i++;
        }
        while (j < word2.length()) {
            ans.append(word2.charAt(j));
            j++;
        }
        return ans.toString();
    }
}