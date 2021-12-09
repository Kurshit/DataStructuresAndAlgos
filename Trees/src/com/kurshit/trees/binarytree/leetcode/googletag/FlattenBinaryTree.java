package com.kurshit.trees.binarytree.leetcode.googletag;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;


public class FlattenBinaryTree {
    public static void main(String[] args) {

        BTREE btree = new BTREE();

        btree.createSampleBinaryTreeFlatten();

        /*
         * 								1
         * 							/	     \
         * 						  2			   5
         * 					   /     \       /      \
         *                   3       4     6       7
         *
         *
         */

        flatten(btree.root);

        btree.preOrder();
        btree.postOrder();

    }

    private static Node prev = null;

    public static void flatten(Node root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
