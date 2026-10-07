class Solution {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0, dfs(node.left));   // ignore negative paths
        int right = Math.max(0, dfs(node.right));
        result = Math.max(result, node.val + left + right); // path through node
        return node.val + Math.max(left, right);  // return only one direction
    }
}