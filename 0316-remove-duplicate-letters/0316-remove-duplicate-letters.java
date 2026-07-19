class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for (int i=0; i<s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        boolean[] inStack = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (inStack[ch - 'a']) {
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && last[sb.charAt(sb.length() - 1) - 'a'] > i) {
                inStack[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(ch);
            inStack[ch - 'a'] = true;
        }
        return sb.toString();
    }
}