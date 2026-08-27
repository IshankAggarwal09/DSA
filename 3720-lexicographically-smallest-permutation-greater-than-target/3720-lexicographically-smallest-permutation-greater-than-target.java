class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] totalCount = new int[26];
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }
        int[] prefixCount = new int[26];
        int maxPrefix = 0;
        while (maxPrefix < n) {
            int charIdx = target.charAt(maxPrefix) - 'a';
            if (prefixCount[charIdx] + 1 <= totalCount[charIdx]) {
                prefixCount[charIdx]++;
                maxPrefix++;
            } 
            else {
                break;
            }
        }
        for (int i=maxPrefix; i>=0; i--) {
            if (i < n) {
                int targetCharIdx = target.charAt(i) - 'a';
                for (int c=targetCharIdx+1; c<26; c++) {
                    if (prefixCount[c] < totalCount[c]) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(target, 0, i);
                        sb.append((char) ('a' + c));
                        prefixCount[c]++;
                        for (int rem=0; rem<26; rem++) {
                            int available = totalCount[rem] - prefixCount[rem];
                            while (available > 0) {
                                sb.append((char) ('a' + rem));
                                available--;
                            }
                        }
                        return sb.toString();
                    }
                }
            }
            if (i > 0) {
                prefixCount[target.charAt(i - 1) - 'a']--;
            }
        }
        return "";
    }
}