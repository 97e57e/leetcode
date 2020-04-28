package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree3 {
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

    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count ++;
        }
        return count;
    }
}
