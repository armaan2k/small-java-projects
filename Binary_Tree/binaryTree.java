import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class binaryTree 
{ 
    // Root of Binary Tree 
    node root; 
  
    // Constructors 
    binaryTree(String value) 
    { 
        root = new node(value); 
    } 
  
    binaryTree() 
    { 
        root = null; 
    } 
    
  //creates binary tree using data from fileLocation
  	public binaryTree loadTreeFromFile(String fileLocation) {
  		stack binaryTreeStack = new stack();
  		
  		Scanner file = null;			
  		try {
  			file = new Scanner(new FileInputStream(fileLocation));
  		}
  		
  		catch (FileNotFoundException e) {
  		
  			System.out.println("ERROR: "+e.getMessage());
  			System.exit(0);
  		}
  		
  		//while loop to read values line by line and add to a stack
  		while (file.hasNextLine()){
  			String line = file.nextLine();
  			String[] lineArr = line.split(" ");
  	  		String value = lineArr[0];
  	  		String leftChildBool = lineArr[1];
  	  		String rightChildBool = lineArr[2];
  	  		binaryTree rightTree = null;
  	  		binaryTree leftTree = null;
  	  		node rightTreeNode = null;
  	  		node leftTreeNode = null;
  	  		if(rightChildBool.equals("1")) {
  	  			try {
  	  				rightTree = (binaryTree) binaryTreeStack.pop();
  	  				rightTreeNode = rightTree.root;
  	  			}catch(Exception e) {
  	  				
  	  			}
  	  			
  	 			}
  	 		if(leftChildBool.equals("1")) {
  	 			leftTree = (binaryTree) binaryTreeStack.pop();
  	 			leftTreeNode = leftTree.root;
 	  		}
  	 		binaryTree newTree = new binaryTree();
  	 		newTree.root = new node(value);
  	 		if(rightChildBool.equals("1")) {
  	 			newTree.root.rightChild = rightTreeNode;
  	 			}
  	 		if(leftChildBool.equals("1")) {
  	 			newTree.root.leftChild = leftTreeNode;
 	  		}
  	 		binaryTreeStack.push(newTree);
  	 		
  	 		}
  		file.close();
  		binaryTree returnTree = (binaryTree) binaryTreeStack.pop();
  		return returnTree;
  	}
  	
  //prints out all the levels
  	void printLevelOrder() 
      { 
          int h = height(root); 
          int i; 
          for (i=1; i<=h; i++) 
              printGivenLevel(root, i); 
      } 
    
      // finds the height of a tree
      int height(node root) 
      { 
          if (root == null) 
             return 0; 
          else
          { 
              //computes the height of each subtree 
              int lheight = height(root.leftChild); 
              int rheight = height(root.rightChild); 
                
              // use the larger subtree
              if (lheight > rheight) 
                  return(lheight+1); 
              else return(rheight+1);  
          } 
      } 
    
      //prints all the nodes from left to right in a given level
      void printGivenLevel (node root ,int level) 
      { 
          if (root == null) 
              return; 
          if (level == 1) 
              System.out.print(root.value + " "); 
          else if (level > 1) 
          { 
              printGivenLevel(root.leftChild, level-1); 
              printGivenLevel(root.rightChild, level-1); 
          } 
      } 
}