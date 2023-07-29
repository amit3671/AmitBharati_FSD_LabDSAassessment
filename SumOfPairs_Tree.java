package collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binary_tree.LevelOrderBTree.Node;


public class SumOfPairs_Tree {
	
	static int k =0;
	static int array[] = new int[1000];
	static int value;
	static Scanner sc = new Scanner(System.in);
	
	Deque<Node>queue = new LinkedList<Node>();
	
	static class Node{
		
		int key;
		Node left;
		Node right;
	}
    
	static Node newNode(int data) {
		Node temp = new Node();
		
		temp.key = data;
		temp.left = null;
		temp.right = null;
		
		return temp;
	}
	
	Node insertNode(Node root, int key) {
		
		
		Node newNode = newNode(key);
		
		if(root == null) {
			root = newNode;
			array[k] = newNode.key;
			k++;
			queue.add(root);
			return root;	
		}
			else {
				Node node;
				node = queue.remove();
				
				if(node.left == null) {
					
					node.left = newNode;
					array[k] = newNode.key;
					k++;
					queue.add(node.left);
					queue.addFirst(node);
					return root;
				}
				
				else if(node.right == null) {
					
					node.right = newNode;
					array[k] = newNode.key;
					k++;
					queue.add(node.right);
					return root;
					}
				}
		return root;
	}
	
public void print_pairs(int i, int value) {
	
	int d=0;
	for(int l=0 ; l<=i-1 ; l++) {
		
		for(int p=i-1; p>l ; p--) {
		
			if(array[l]+array[p] == value) {
		System.out.print("Pair is (" +array[l]+ ","+ array[p]+ ")\n");
			d++;
			}
		}
	}
	if(d == 0) {
		System.out.print("Nodes are not found.");
	}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SumOfPairs_Tree STree = new SumOfPairs_Tree();
		Node root = null;
		String status = "p";
		int i =0;
		while(!status.equals("e")) {
			System.out.println("Enter the value of the node that you want to insert in the tree");
			value = sc.nextInt();
			root = STree.insertNode(root,value);
			i++;
			System.out.println("Press ''e'' to exit the tree or any other key to continue to enter the nodes");
			status = sc.next();
		}
	        System.out.println("Enter the value of sum you want to check");
	        int value = sc.nextInt();
		System.out.println("Sum = "+value);
		STree.print_pairs(i,value);
	}

}
