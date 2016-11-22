package com.yk.example.algorithm;

import org.junit.Before;
import org.junit.Test;

import com.yk.example.algorithm.BinarySearchTree.BinaryNode;


public class BinarySearchTreeTest {
	
	BinaryNode<Integer> root,node1,node2,node3,node4,node8;
	BinarySearchTree bst;

	@Before
	public void init(){
		 node3 = new BinaryNode<Integer>(3);
	     node1 = new BinaryNode<Integer>(1);
	     node4 = new BinaryNode<Integer>(4, node3, null);
	     node2 = new BinaryNode<Integer>(2, node1, node4);
	     node8 = new BinaryNode<Integer>(8);
	     root = new BinaryNode<Integer>(6, node2, node8);
	     bst = new BinarySearchTree();
	}
	
	@Test
	public void test() {
		bst.preOrder(root);
		System.out.println("----------");
		System.out.println(bst.findMax(root).data);;
		System.out.println(bst.findMin(root).data);;
		System.out.println(bst.contains(1,root));;
	}

}
