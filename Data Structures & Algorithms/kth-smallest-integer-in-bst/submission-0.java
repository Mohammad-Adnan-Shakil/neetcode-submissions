class Solution {
    int result = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        count--;
        if(count == 0){
            result = node.val;
            return;
        }
        inorder(node.right);
    }
}