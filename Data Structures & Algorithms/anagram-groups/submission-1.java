class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // 1. Create a map: key = sorted word, value = list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            
            // 2. Sort the word to get the key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // 3. If key doesn't exist yet, create empty list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // 4. Add original word to its group
            map.get(key).add(word);
        }

        // 5. Return all groups
        return new ArrayList<>(map.values());
    }
}