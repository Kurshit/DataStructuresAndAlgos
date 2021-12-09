package com.kurshit.trees.binarytree.leetcode.googletag;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

import java.util.ArrayList;
import java.util.List;

public class LCAInBtree {

    public static void main(String[] args) {

        BTREE btree = new BTREE();

        btree.root = new Node(3);
        btree.root.left = new Node(5);
        Node q = btree.root.right = new Node(1);
        btree.root.left.left = new Node(6);
        Node p = btree.root.left.right = new Node(2);
        btree.root.right.left = new Node(0);
        btree.root.right.right = new Node(8);
        btree.root.left.right.left = new Node(7);
        btree.root.left.right.right = new Node(4);

        LCAInBtree l = new LCAInBtree();

        l.populateParent(btree.root, null);

        System.out.println(l.lowestCommonAncestor(p, q).data);
        System.out.println(l.lcaEasiest(p, q).data);
    }

    public Node lcaEasiest(Node p, Node q) {

        Node a = p;
        Node b = q;

        while(a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }

        return a;
    }

    public Node lowestCommonAncestor(Node p, Node q) {

        List<Node> pParent = new ArrayList<>();

        List<Node> qParent = new ArrayList<>();

        Node ptr = p;

        while(ptr != null) {
            pParent.add(ptr);
            ptr = ptr.parent;
        }
        ptr = q;
        while(ptr != null) {
            qParent.add(ptr);
            ptr = ptr.parent;
        }

        int i = pParent.size() - 1;
        int j = qParent.size() - 1;

        Node result = null;

        while(i >= 0 && j >= 0) {

            if(pParent.get(i) == qParent.get(j)) {
                result = pParent.get(i);
                i--;
                j--;
                continue;
            } else {
                break;
            }

        }

        return result;


    }

    public void populateParent(Node root, Node parent) {

        if(root == null)
            return;

        populateParent(root.left, root);
        root.parent = parent;
        populateParent(root.right, root);

    }

}
