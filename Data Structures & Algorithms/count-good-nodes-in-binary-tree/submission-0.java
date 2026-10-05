class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar){
        if(node == null) return 0;
        int count = node.val >= maxSoFar ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, node.val);
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);
        return count;
    }
}