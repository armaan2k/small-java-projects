/*
Name: Armaan Merchant
student #: 20047267
Description: AVL tree implementation
 */

import java.util.ArrayList;

public class AVLtree<T extends Comparable<T>>{

  public class Node{

    // 'bf' is short for Balance Factor
    public int bf;

    // The value/data contained within the node.
    public T key;

    // The value/data contained within the node.
    public T value;

    // The height of this node in the tree.
    public int height;

    // The left and the right children of this node.
    public Node left, right;

    public Node(T key, T value) {
      this.key = key;
      this.value = value;
    }
  }

  ArrayList<T> visited = new ArrayList<T>();

  // The root node of the AVL tree.
  public Node root;

  // The height of a rooted tree is the number of edges between the tree root and its furthest leaf
  public int height() {
    if (root == null) return 0;
    return root.height;
  }

  // Return true/false depending on whether a key exists in the tree.
  public boolean contains(T key) {
    return contains(root, key);
  }

  // Recursive contains helper method.
  private boolean contains(Node node, T key) {

    if (node == null) return false;

    // Compare current value to the value in the node.
    int cmp = key.compareTo(node.key);

    // Dig into left subtree.
    if (cmp < 0) return contains(node.left, key);

    // Dig into right subtree.
    if (cmp > 0) return contains(node.right, key);

    // Found value in tree.
    return true;
  }

  // Returns value of a node depending on whether a key exists in the tree.
  public T get(T key) {
    return get(root, key);
  }

  // Recursive contains helper method.
  private T get(Node node, T key) {

    if (node == null) return null;

    // Compare current key to the key in the node.
    int cmp = key.compareTo(node.key);

    // Dig into left subtree.
    if (cmp < 0) return get(node.left, key);

    // Dig into right subtree.
    if (cmp > 0) return get(node.right, key);

    // Found key in tree.
    return node.value;
  }

  // Insert a key to the AVL tree
  public boolean put(T key, T value) {
    if (key == null) return false;
    if (!contains(root, key)) {
      root = put(root, key, value);
      return true;
    }
    return false;
  }

  // Inserts a key inside the AVL tree.
  private Node put(Node node, T key, T value) {

    // Base case.
    if (node == null) return new Node(key, value);

    // Compare current key to the key in the node.
    int cmp = key.compareTo(node.key);

    // Insert node in left subtree.
    if (cmp < 0) {
      node.left = put(node.left, key, value);
      // Insert node in right subtree.
    } else {
      node.right = put(node.right, key, value);
    }
    // Update balance factor and height values.
    update(node);

    // Re-balance tree.
    return balance(node);
  }

  // Update a node's height and balance factor.
  private void update(Node node) {

    int leftNodeHeight = (node.left == null) ? -1 : node.left.height;
    int rightNodeHeight = (node.right == null) ? -1 : node.right.height;

    // Update this node's height.
    node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

    // Update balance factor.
    node.bf = rightNodeHeight - leftNodeHeight;
  }

  // Re-balance a node if its balance factor is +2 or -2.
  private Node balance(Node node) {

    // Left heavy subtree
    if (node.bf == -2) {

      // Left-Left case.
      if (node.left.bf <= 0) {
        return leftLeftCase(node);

        // Left-Right case.
      } else {
        return leftRightCase(node);
      }

      // Right heavy subtree
    } else if (node.bf == +2) {

      // Right-Right case.
      if (node.right.bf >= 0) {
        return rightRightCase(node);

        // Right-Left case.
      } else {
        return rightLeftCase(node);
      }
    }

    // now Node either has a balance factor of 0, +1 or -1
    return node;
  }

  private Node leftLeftCase(Node node) {
    return rightRotation(node);
  }

  private Node leftRightCase(Node node) {
    node.left = leftRotation(node.left);
    return leftLeftCase(node);
  }

  private Node rightRightCase(Node node) {
    return leftRotation(node);
  }

  private Node rightLeftCase(Node node) {
    node.right = rightRotation(node.right);
    return rightRightCase(node);
  }

  private Node leftRotation(Node node) {
    Node newParent = node.right;
    node.right = newParent.left;
    newParent.left = node;
    update(node);
    update(newParent);
    return newParent;
  }

  private Node rightRotation(Node node) {
    Node newParent = node.left;
    node.left = newParent.right;
    newParent.right = node;
    update(node);
    update(newParent);
    return newParent;
  }


  //calls the searchPath function to run recursively
  public ArrayList<T> searchPath(T key) {
    return _searchPath(root, key);
  }

  //finds a given value/node and returns all nodes visited in the process
  public ArrayList<T> _searchPath (Node current, T key) {
    if(current == root) {
      visited.clear();
    }

    if (current == null) {
      return visited;
    }

    int cmp = key.compareTo(current.key);

    if (cmp == 0) {
      visited.add(key);
      return visited;
    }

    if (cmp>0) {
      visited.add(current.key);
      return _searchPath(current.right, key);
    }

    if (cmp<0) {
      visited.add(current.key);
      return _searchPath(current.left, key);
    }
    visited.add(key);
    return visited;
  }
}