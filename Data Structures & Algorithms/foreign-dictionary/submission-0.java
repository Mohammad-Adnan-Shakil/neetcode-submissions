class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String word : words)
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            // invalid: prefix word comes after longer word
            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";
            for(int j = 0; j < minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        // BFS topological sort
        Queue<Character> queue = new LinkedList<>();
        for(char c : indegree.keySet())
            if(indegree.get(c) == 0) queue.add(c);

        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.poll();
            result.append(c);
            for(char neighbor : adj.get(c)){
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) queue.add(neighbor);
            }
        }

        return result.length() == indegree.size() ? result.toString() : "";
    }
}