package com.hackerrank.questions;

public class LinkedListAlgorithms {

	Node insertAtIndex(Node head, int data, int position) {
		Node newNode = new Node();
		newNode.data = data;

		if (head == null) {
			return newNode;
		}

		if (position == 0) {
			newNode.next = head;
			return newNode;
		}

		Node current = head;
		for (int i = 0; i < position - 1; i++) {
			current = current.next;
		}

		Node next = current.next;
		current.next = newNode;
		newNode.next = next;

		return head;
	}

	Node replaceHead(Node head, int x) {
		Node newHead = new Node();
		newHead.data = x;
		newHead.next = head;
		return newHead;
	}

	Node deleteAtIndex(Node head, int position) {
		if (head == null) {
			return head;
		}

		if (position == 0) {
			head = head.next;
			return head;
		}

		Node current = head;
		Node previous = current;
		for (int i = 0; i < position; i++) {
			previous = current;
			current = current.next;
		}

		Node delete = current;
		delete = null;
		previous.next = current.next;

		return head;
	}

	Node reverse(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node currentNode = head;
		Node previousNode = null;
		Node nextNode = null;

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}

		head = previousNode;

		return head;
	}

	void printLinkedList(Node head) {
		Node node = head;

		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
