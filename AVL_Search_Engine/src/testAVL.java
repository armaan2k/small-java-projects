/*
Name: Armaan Merchant
Description: test for AVL tree implementation
 */
import java.sql.SQLOutput;
import java.util.Scanner;
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

    System.out.println("Testing fuctionality of AVL tree:");
    System.out.println("Search path for node 15: " + tree.searchPath(15));
    System.out.println("Searching for node 10: " + tree.get(10));
    System.out.println("Searching for node 15: " + tree.get(15));
    System.out.println("Searching for node 1: " + tree.get(1));


    WebPageIndex webIndex = new WebPageIndex("search_file.txt");
    AVLtree webIndexAVL = webIndex.intoAVL();

    Scanner input = new Scanner(System.in);
    while(true){
      System.out.println("\nEnter your search word or 'exit' to Quit:");
      String search_word = input.nextLine();
      if(search_word.equals("exit")){
        break;
      }
      System.out.println(search_word + " has come up " + webIndexAVL.get(search_word) + " times");

    }


  }

}
