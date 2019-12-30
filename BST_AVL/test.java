/*
 * name: Armaan Merchant
 * student number: 20047267
 * description: test cases 1,3,4,5
 */
public class test {

	public static void main(String[] args) {
		
		
		//testing the loadTreeFromFile and printLevelOrder function. TEST case #5
		binarySearchTree tree = new binarySearchTree();
		tree.insert(4);
		tree.insert(2);
		tree.insert(8);
		tree.insert(5);
		tree.insert(10);
		System.out.println(tree.getTotalDepth());
		System.out.println(tree.getWeightBalanceFactor());
		System.out.println(tree.searchPath(10));



		
		
		
		
		
		
		
		
		
		
	}

	
}
