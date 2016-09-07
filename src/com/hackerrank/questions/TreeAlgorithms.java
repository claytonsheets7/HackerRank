package com.hackerrank.questions;

import java.util.HashSet;
import java.util.Set;

public class TreeAlgorithms {

	Set<Integer> valuesSeen = new HashSet<Integer>();

	boolean checkBST(Node root) {
		if (root == null) {
			return true;
		}
		return checkBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	public boolean checkBSTHelper(Node root, int rightMax, int leftMin) {
		if (valuesSeen.contains(root.data)) {
			return false;
		}
		valuesSeen.add(root.data);
		if (root.right != null && root.left != null) {
			if (root.right.data > leftMin && root.right.data < rightMax && root.left.data < rightMax
					&& root.left.data > leftMin) {
				return checkBSTHelper(root.right, rightMax, root.data) && checkBSTHelper(root.left, root.data, leftMin);
			}
			return false;
		} else if (root.right != null) {
			if (root.right.data > leftMin && root.right.data < rightMax) {
				return checkBSTHelper(root.right, rightMax, root.data);
			}
			return false;
		} else if (root.left != null) {
			if (root.left.data < rightMax && root.left.data > leftMin) {
				return checkBSTHelper(root.left, root.data, leftMin);
			}
			return false;
		} else {
			return true;
		}

	}

	static Node lowestCommonAncestor(Node root, int node1, int node2) {
		if (root.data < node1 && root.data < node2) {
			return lowestCommonAncestor(root.right, node1, node2);
		}

		if (root.data > node1 && root.data > node2) {
			return lowestCommonAncestor(root.left, node1, node2);
		}

		return root;
	}

	static Node Insert(Node root, int value) {

		if (root != null) {
			if (root.data > value) {
				root.left = Insert(root.left, value);
			} else if (root.data < value) {
				root.right = Insert(root.right, value);
			}
		} else {
			Node node = new Node();
			node.data = value;
			node.left = null;
			node.right = null;
			root = node;
		}

		return root;
	}

	int height(Node root) {
		if (root == null) {
			return -1;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	void inOrder(Node root) {
		if (root.left != null) {
			inOrder(root.left);
		}
		System.out.print(root.data + " ");
		if (root.right != null) {
			inOrder(root.right);
		}
	}

	void postOrder(Node root) {
		if (root.left != null) {
			postOrder(root.left);
		}
		if (root.right != null) {
			postOrder(root.right);
		}
		System.out.print(root.data + " ");
	}

	void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			if (root.left != null) {
				preOrder(root.left);
			}
			if (root.right != null) {
				preOrder(root.right);
			}
		}
	}

}
