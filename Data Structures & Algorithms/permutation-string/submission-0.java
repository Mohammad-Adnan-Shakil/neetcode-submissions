class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // fill initial window
        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Count, s2Count)) return true;

        // slide window
        for(int right = s1.length(); right < s2.length(); right++){
            s2Count[s2.charAt(right) - 'a']++;                          // add right
            s2Count[s2.charAt(right - s1.length()) - 'a']--;            // remove left
            if(Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }
}