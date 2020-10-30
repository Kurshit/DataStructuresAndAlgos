package com.kurshit.trees.binarytree.traversals;

import java.util.ArrayList;
import java.util.List;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;


public class ZigZagTraversal {
	
public int height(Node root) {
        
        if(root == null)
            return 0;
        
        int lheight = height(root.left) + 1;
        int rheight = height(root.right) + 1;
        
        return Math.max(lheight,rheight);
        
    }
    
    public List<Integer> printGivenLevelNodes(Node root, int level, boolean itr, List<Integer> localList) {
        
        if(root == null)
            return localList;
        
        if(level ==1)
            localList.add(root.data);
            
        if(!itr) {
            printGivenLevelNodes(root.right, level -1, itr, localList);
            printGivenLevelNodes(root.left, level -1, itr, localList);
        } else {
            printGivenLevelNodes(root.left, level -1, itr, localList);
            printGivenLevelNodes(root.right, level -1, itr, localList);            
        }
        
        return localList;
        
    }
    
    public List<List<Integer>> list = new ArrayList<>();
    
        
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        
        int height = height(root);
        
        boolean itr = true;
        
        for(int i =1; i<= height; i++) {
            
            list.add(printGivenLevelNodes(root,i,itr, new ArrayList<Integer>()));
            
            itr = !itr;
            
        }
        
        return list;
        
    }
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		//btree.createSampleBinaryTree();
		
		btree.root = new Node(3);
		
		btree.root.left = new Node(9);
		
		btree.root.right = new Node(20);
		
		btree.root.right.left = new Node(15);
		btree.root.right.right = new Node(7);
		
		ZigZagTraversal zz = new ZigZagTraversal();
		
		List<List<Integer>> zigzagLevelOrder = zz.zigzagLevelOrder(btree.root);
		System.out.println(zigzagLevelOrder);
		
		
		

	}

}
