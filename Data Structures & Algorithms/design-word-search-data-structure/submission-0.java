class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(curr.children[idx] == null)
                curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node){
        if(index == word.length()) return node.isEnd;

        char c = word.charAt(index);
        if(c == '.'){
            // try all 26 children
            for(TrieNode child : node.children){
                if(child != null && dfs(word, index + 1, child))
                    return true;
            }
            return false;
        } else {
            int idx = c - 'a';
            if(node.children[idx] == null) return false;
            return dfs(word, index + 1, node.children[idx]);
        }
    }
}