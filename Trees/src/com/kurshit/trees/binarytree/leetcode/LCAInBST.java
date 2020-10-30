package com.kurshit.trees.binarytree.leetcode;

import com.kurshit.trees.binarytree.BTREE.Node;

public class LCAInBST {
	
	public Node lcaRecursively(Node root, int n1, int n2) {
		if(root == null)
			return null;
		
		if(n1 < root.data  && n2 < root.data ) {
			return lcaRecursively(root.left, n1, n2);
		}
		
		if(n1 > root.data && n2 > root.data ) {
			return lcaRecursively(root.right, n1, n2);			
		}
		
		return root;
	}
	
	/*
	 *  Ain't working
	 */
	
	/*public int lcaUsingHash(Node root, int n1, int n2) {
		
		if(root == null)
			return -1;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(root.data, -1);
		
		populateParentMap(root,map);
		
		int first = n1;
		int second = n2;
		
		int result = -1;
		
		while(n1 != -1 && n2 != -1) {
			
			n1 = map.get(n1);
			n2 = map.get(n2);
			
			if(n1 == n2) {
				result = n1;
				break;
			}
			
		}
		
		if(n1 == -1) 
			return root.data;
		
		return result;
	}
	
	public void populateParentMap(Node root, HashMap<Integer,Integer> parentMap) {
		
		if(root == null)
			return;
		
		populateParentMap(root.left, parentMap);
		
		if(root.left != null ) {			
			parentMap.put(root.left.data, root.data);			
		}
		
		if(root.right != null ) {			
			parentMap.put(root.right.data, root.data);			
		}		
		
		populateParentMap(root.right, parentMap);
		
	}
*/
	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.createSampleTree();
		
		
		LCAInBST lca = new LCAInBST();
		int n1 = 20;
		int n2 = 45;
		Node result = lca.lcaRecursively(bst.root, n1, n2);
		System.out.println("LCA of "+ n1 + " , " + n2 + "  :" +result.data);
		
		
		System.out.println();

		/*
		 * 							  50
		 * 					     /         \
 		 *  				 30               70
		 *              /         \      /         \
		 *           20           40   60            80
		 *        /      \     /   \              /      \
		 *      15      25   35     45          75        85
		 *     / 
		 *    10  
		 *      
		 */
		
		n1 = 30; n2 = 80;
		result = lca.lcaRecursively(bst.root, n1, n2);
		System.out.println("LCA of "+ n1 + " , " + n2 + "  :" +result.data);
		
		
		System.out.println();
		
		n1 = 10; n2 = 40;
		result = lca.lcaRecursively(bst.root, n1, n2);
		
		System.out.println();
		
		n1 = 30; n2 = 45;
		result = lca.lcaRecursively(bst.root, n1, n2);
		System.out.println("LCA of "+ n1 + " , " + n2 + "  :" +result.data);
		
		
		System.out.println();
		
	}

}
