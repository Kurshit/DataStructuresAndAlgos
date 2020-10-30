package com.kurshit.trees.binarytree.traversals;

import java.util.ArrayList;
import java.util.List;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;


public class LevelOrderTraversalOnNewLineAsListOfList {

    
    public int height(Node root) {
        
        if(root == null)
            return 0;
        
        int lheight = 1 +height(root.left);
        int rheight = 1 +height(root.right);
        
        return Math.max(lheight,rheight);
        
        
    }
    
    public List<Integer> printNodesAtGivenLevel(Node root, int level, List<Integer> localList) {
        
        if(root == null)
            return localList;
        
        if(level == 1) {
            localList.add(root.data);
        }
        
        printNodesAtGivenLevel(root.left, level - 1, localList);
        printNodesAtGivenLevel(root.right, level - 1, localList);
        
        return localList;
        
    }
    
    List<List<Integer>> list = new ArrayList<>();
    
    
    public List<List<Integer>> levelOrder(Node root) {
        
        int height = height(root);
        
        for(int i=1; i <=height; i++)
        {
            list.add(printNodesAtGivenLevel(root, i, new ArrayList<Integer>()));
            
        }
        
        return list;
        
        
        
    }

	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		btree.createSampleBinaryTree1();
		btree.inOrder();
		
		LevelOrderTraversalOnNewLineAsListOfList lot = new LevelOrderTraversalOnNewLineAsListOfList();
		
		List<List<Integer>> levelOrder = lot.levelOrder(btree.root);
		
		System.out.println(levelOrder);

	}

}
