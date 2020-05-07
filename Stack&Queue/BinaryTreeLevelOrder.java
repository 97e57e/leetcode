package leetcode.stackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTree {
    int val;
    BinaryTree leftChild;
    BinaryTree rightChild;

    BinaryTree(int val) {
        this.val = val;
    }
}

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree(3);
        bTree.leftChild = new BinaryTree(4);
        bTree.rightChild = new BinaryTree(5);
        bTree.leftChild.leftChild = new BinaryTree(6);
        bTree.leftChild.rightChild = new BinaryTree(7);

        System.out.println(solve(bTree));
    }

    public static List<List<Integer>> solve(BinaryTree bTree) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();

        if (bTree == null)
            return list;

        queue.offer(bTree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++) {
                BinaryTree node = queue.poll();
                level.add(node.val);

                if (node.leftChild != null) {
                    queue.offer(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.offer(node.rightChild);
                }
            }
            list.add(level);
        }

        return list;
    }
}
