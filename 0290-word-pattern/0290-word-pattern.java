class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        int n = pattern.length();
        if (n != str.length) {
            return false;
        }
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i=0; i<n; i++) {
            if (map1.containsKey(pattern.charAt(i))) {
                if (!map1.get(pattern.charAt(i)).equals(str[i])) {
                    return false;
                }
            }
            else {
                if (map2.containsKey(str[i])) {
                    return false;
                }
            }
            map1.put(pattern.charAt(i), str[i]);
            map2.put(str[i], pattern.charAt(i));
        }
        return true;
    }
}