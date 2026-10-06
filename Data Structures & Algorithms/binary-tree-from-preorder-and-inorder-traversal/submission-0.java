class Solution {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderMap.get(rootVal); // root position in inorder
        int leftSize = mid - inStart;

        root.left = build(preorder, preStart+1, preStart+leftSize, inStart, mid-1);
        root.right = build(preorder, preStart+leftSize+1, preEnd, mid+1, inEnd);

        return root;
    }
}