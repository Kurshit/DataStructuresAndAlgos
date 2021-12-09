package com.kurshit.trees.binarytree.leetcode.googletag;

/*
    Problem : Delete nodes and return forest #1110
    Problem Source : https://leetcode.com/problems/delete-nodes-and-return-forest/
    Problem : Given the root of a binary tree, each node in the tree has a distinct value.

    After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

    Return the roots of the trees in the remaining forest. You may return the result in any order.

    Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
    Output: [[1],[6],[7]]

 */


import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

import javax.swing.tree.TreeNode;
import java.util.*;

public class DeleteNodesReturnForest {

    public static void main(String[] args) {

        BTREE btree = new BTREE();

        btree.createSampleBinaryTree1();

        /*
         * 								10
         * 							/	     \
         * 						  5			   20
         * 					   /     \       /      \
         *                   9       7     30       40
         * 				  /    \    / \
         * 				 70    80  50  60
         */

        int[] to_delete = {20, 7, 9};

        DeleteNodesReturnForest del = new DeleteNodesReturnForest();

        System.out.println(del.delNodesBFS(btree.root, to_delete));
        //System.out.println(del.delNodesRecursion(btree.root, to_delete));

        btree.clear();

        btree.createSampleBinaryTreeForest();
        int[] to_delete1 = {3, 5};
        System.out.println(del.delNodesRecursion(btree.root, to_delete1));
        //System.out.println(del.delNodesRecursion(btree.root, to_delete1));



        /*
         * 								1
         * 							/	     \
         * 						  2			   3
         * 					   /     \       /      \
         *                   4       5     6        7
         *
         *
         */
    }

    /*
        Using BFS
     */

    public List<Node> delNodesBFS(Node root, int[] to_delete) {

        if (root == null) return new ArrayList<>();

        Set<Integer> delSet = new HashSet<>();
        Set<Node> resultSet = new HashSet<>();

        if (to_delete.length == 0) return new ArrayList<>(resultSet);


        for(int item : to_delete) {
            delSet.add(item);
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        resultSet.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(delSet.contains(temp.data)) {
                resultSet.remove(temp);

                if(temp.left != null)
                    resultSet.add(temp.left);

                if(temp.right != null)
                    resultSet.add(temp.right);
            }

            if(temp.left != null) {

                queue.offer(temp.left);

                if(delSet.contains(temp.left.data)) {
                    temp.left = null;
                }
            }

            if(temp.right != null) {

                queue.offer(temp.right);

                if(delSet.contains(temp.right.data)) {
                    temp.right = null;
                }

            }
        }

        return new ArrayList(resultSet);
    }

    Set<Integer> delSet;
    List<Node> result;

    public List<Node> delNodesRecursion(Node root, int[] to_delete) {

        delSet = new HashSet<>();

        for(int item : to_delete) {
            delSet.add(item);
        }

        result = new ArrayList<>();

        util(root, true);
        return result;

    }

    public Node util(Node root, boolean isRoot) {
        if(root == null)
            return null;

        boolean isDeleted = delSet.contains(root.data);

        if(isRoot && !isDeleted) {
            result.add(root);
        }

        root.left = util(root.left, isDeleted);
        root.right = util(root.right, isDeleted);

        return isDeleted ? null : root;
    }




}
