class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        HashMap<Character, Integer> tCount = new HashMap<>();
        for(char c : t.toCharArray()){
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = tCount.size();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int resLen = Integer.MAX_VALUE;
        int resLeft = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // check if this char satisfies t's requirement
            if(tCount.containsKey(c) && window.get(c).equals(tCount.get(c))){
                have++;
            }

            // shrink from left while window is valid
            while(have == need){
                // update result
                if(right - left + 1 < resLen){
                    resLen = right - left + 1;
                    resLeft = left;
                }
                // remove left char
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if(tCount.containsKey(leftChar) && window.get(leftChar) < tCount.get(leftChar)){
                    have--;
                }
                left++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resLeft + resLen);
    }
}