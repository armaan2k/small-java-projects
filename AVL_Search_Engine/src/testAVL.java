/*
Name: Armaan Merchant
Description: test for AVL tree implementation
 */
public class testAVL {

  public static void main(String[] args) {
    AVLtree tree = new AVLtree();
    tree.put(4, "dog");
    tree.put(2, "cat");
    tree.put(8,"mouse");
    tree.put(5,"bob");
    tree.put(10, "jim");
    tree.put(1, "carl");
    tree.put(15, "fish");

    System.out.println(tree.searchPath(15));
    System.out.println(tree.get(10));
    System.out.println(tree.get(15));
    System.out.println(tree.get(111));


    WebPageIndex webIndex = new WebPageIndex("doc1-arraylist.txt");
    AVLtree webIndexAVL = webIndex.intoAVL();
    System.out.println(webIndexAVL.get("array"));


  }

}
