/*
 * name: Armaan Merchant
 * student number: 20047267
 * description: test cases 1,3,4,5
 */
public class test {

	public static void main(String[] args) {
		
		
		//testing the loadTreeFromFile and printLevelOrder function. TEST case #5
		binaryTree figure1Tree = new binaryTree();
		binaryTree figure1Tree2 = new binaryTree();
		figure1Tree2 = figure1Tree.loadTreeFromFile("binarySearchTree.txt");
		figure1Tree2.printLevelOrder();
		
		binaryTree Tree = new binaryTree();
		binaryTree Tree2 = new binaryTree();
		Tree2 = Tree.loadTreeFromFile("expressionTree.txt");
		Tree2.printLevelOrder();
		
		
		
		
		
		
		
		
		
		
	}

	
}
