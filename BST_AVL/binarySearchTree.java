/*
 * name: Armaan Merchant
 * student number: 20047267
 * description: a binary search tree data structure
 */

import java.util.ArrayList;

public class binarySearchTree {

	int maxDiff=0;
	int totalDepth=0;
	static node root;
	ArrayList<Integer> visited = new ArrayList<Integer>();

	public static void main(String[] args) {

	}

	//calls insert function to run recursively
	public void insert(int value) {
		root = _insert(root, value);
	}

	//inserts a given value as a node into a tree
	public node _insert(node current, int value) {
		if(current==null) {
			return new node(value);
		}

		//finding where in the tree to put the value
		if (value < current.value) {
			current.leftChild = _insert(current.leftChild, value);
		}
		if (value > current.value) {
			current.rightChild = _insert(current.rightChild, value);
		}

		return current;
	}

	//calls the searchPath function to run recursively
	public ArrayList<Integer> searchPath(int value) {
		return _searchPath(root, value);
	}

	//finds a given value/node and returns all nodes visited in the process
	public ArrayList<Integer> _searchPath (node current, int value) {
		if(current == root) {
			visited.clear();
		}

		if (current == null) {
			return visited;
		}

		if (value == current.value) {
			visited.add(value);
			return visited;
		}

		if (value>current.value) {
			visited.add(current.value);
			return _searchPath(current.rightChild, value);
		}

		if (value<current.value) {
			visited.add(current.value);
			return _searchPath(current.leftChild, value);
		}
		visited.add(value);
		return visited;
	}

	//calls getTotalDepth function to run recursively
	//resets value of total depth to 0 for every time it is called
	public int getTotalDepth() {
		totalDepth=0;
		return _getTotalDepth(root, 0);
	}

	//finds the total depth of a tree
	public int _getTotalDepth (node current, int level) {
		//to be run if the tree is empty
		if(current == null) {
			return totalDepth;
		}
		else{
			totalDepth = totalDepth + level;
			_getTotalDepth(current.leftChild, level+1);
			_getTotalDepth(current.rightChild, level+1);
		}
		return totalDepth;
	}

	//calls getWeightBalanceFactor function to run recursively
	//resets value of max difference (imbalance) to 0 for every time it is called
	public int getWeightBalanceFactor() {
		maxDiff=0;
		_getWeightBalanceFactor(root);
		return maxDiff;
	}

	//finds the greatest weight imbalance within a tree
	public int _getWeightBalanceFactor(node current) {
		if (current == null)
			return 0;

		if (current.leftChild == null && current.rightChild == null)
			return 1;

		//recursively checks the depth of the nodes
		int heightL = _getWeightBalanceFactor(current.leftChild);
		int heightR = _getWeightBalanceFactor(current.rightChild);
		int absoluteValue;

		//ensures the value is a positive integer
		if((heightL - heightR)<0) {
			absoluteValue = (heightL - heightR)*(-1);
		}
		else {
			absoluteValue = (heightL - heightR);
		}

		//checks whether the imbalance is greater than a previously saved one
		if(absoluteValue>maxDiff) {
			maxDiff = absoluteValue;
		}

		return heightL + heightR + 1;
	}

}
