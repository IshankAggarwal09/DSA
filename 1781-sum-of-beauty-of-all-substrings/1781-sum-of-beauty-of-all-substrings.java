class Solution {
    public int beautySum(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            int[] freq = new int[26];
            for (int j=i; j<s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;
                for (int f=0; f<26; f++) {
                    if (freq[f] > 0) {
                        maxFreq = Math.max(maxFreq, freq[f]);
                        minFreq = Math.min(minFreq, freq[f]);
                    }
                }
                count += maxFreq - minFreq;
            }
        }
        return count;
    }
}