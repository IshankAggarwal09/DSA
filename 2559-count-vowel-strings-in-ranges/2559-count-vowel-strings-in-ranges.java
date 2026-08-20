class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int[] prefix = new int[words.length];
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            if (("aeiou".indexOf(word.charAt(0)) != -1) && ("aeiou".indexOf(word.charAt(word.length()-1)) != -1)) {
                prefix[i] = (i == 0) ? 1 : prefix[i-1] + 1;
            }
            else {
                prefix[i] = (i == 0) ? 0 : prefix[i-1];
            }
        }
        int i = 0;
        for (int[] query : queries) {
            ans[i] = query[0] == 0 ? prefix[query[1]] : prefix[query[1]] - prefix[query[0] - 1];
            i++;
        }
        return ans;
    }
}