package leetcode.graph;

import java.util.Stack;

public class MaximunDepthOfBinaryTree2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(7);

        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        int maxDepth = maximumDepthOfBinaryTree.maxDepth(root);
        System.out.println(maxDepth);
    }

    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max=0;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println("node: "+node.val);
            int count =     value.pop();
            max =Math.max(max, count);
            if(node.left !=null) {
                stack.push(node.left);
                value.push(count+1);
            }
            if(node.right !=null) {
                stack.push(node.right);
                value.push(count+1);
            }
        }
        return max;
    }
}
