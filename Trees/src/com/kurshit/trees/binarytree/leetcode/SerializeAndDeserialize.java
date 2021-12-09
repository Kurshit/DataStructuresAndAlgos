package com.kurshit.trees.binarytree.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class SerializeAndDeserialize {

	// Serialization

	public String rserialize(Node root, String str) {
		// Recursive serialization.
		if (root == null) {
			str = str + "null,";
		} else {
			str = str + String.valueOf(root.data) + ",";
			str = rserialize(root.left, str);
			str = rserialize(root.right, str);
		}
		return str;
	}

	// Encodes a tree to a single string.
	public String serialize(Node root) {
		String result = rserialize(root, "");
		return result.substring(0,result.length()-1); //substring -1 to avoid extra comma
		//return result;
	}


	public Node rdeserialize(List<String> l) {
		// Recursive deserialization.
		if (l.get(0).equals("null")) {
			l.remove(0);
			return null;
		}

		Node root = new Node(Integer.valueOf(l.get(0)));
		l.remove(0);
		root.left = rdeserialize(l);
		root.right = rdeserialize(l);

		return root;
	}

	// Decodes your encoded data to tree. - Preorder
	public Node deserialize(String data) {
		String[] data_array = data.split(",");
		List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		return rdeserialize(data_list);
	}

	public String serializeLevelOrder(Node root) {
		if(root == null)  {
			return "null";
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		StringBuilder resultString = new StringBuilder();
		// use tree level order traversal to serialize the tree
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			if(temp == null) {
				resultString.append("null,");
			} else{
				resultString.append(temp.data + ",");
				queue.add(temp.left);
				queue.add(temp.right);
			}
		}
		String result = resultString.toString().trim();
		return result.substring(0,result.length()-1);
	}

	// Decodes your encoded data to tree.
	public Node deserializeLevelOrder(String data) {
		
		if(data == "")  {
			return null;
		}
		
		String[] vals = data.split(",");
		
		if(vals.length == 0) {
			return null;
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		Node root = new Node(Integer.valueOf(vals[0]));
		
		queue.add(root);
		 
		String val;
		
		for(int i = 1; i < vals.length; ) {
		
			Node temp = queue.poll();
			val = vals[i++];
			
			if(val.equals("null")) {
				temp.left = null;
			} else {
				temp.left = new Node(Integer.valueOf(val));
				queue.add(temp.left);
			}
			
			if(i < vals.length) {
				val = vals[i++];
				
				if(val.equals("null")) {
					temp.right = null;
				} else {
					temp.right = new Node(Integer.valueOf(val));
					queue.add(temp.right);
				}
			}
		}
		return root;
	}


	public static void main(String[] args) {

		BTREE btree = new BTREE();

		btree.createSampleBinaryTree2();

		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     
		 *                   9       
		 * 		
		 */

		SerializeAndDeserialize serialize = new SerializeAndDeserialize();

		String result = serialize.serialize(btree.root);

		System.out.println(result);

		Node newHead = serialize.deserialize(result);

		btree.preOrder(newHead);
		
		result = serialize.serializeLevelOrder(btree.root);
		
		System.out.println("\n-------------------");
		
		System.out.println("Level order : " + result);
		
		newHead = serialize.deserializeLevelOrder(result);
		
		btree.levelOrderTraversalNode(newHead);

	}

}
