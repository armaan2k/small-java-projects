import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WebPageIndex {

  private final String fileName;

  public WebPageIndex(String fileName) {
    this.fileName = fileName;
  }

  public AVLtree intoAVL() {
    File file = new File(fileName);
    String line;
    String[] wordArr;
    AVLtree returnTree = new AVLtree();
    int index = 0;
    int[] indexArr = new int[100];
    try (Scanner sc = new Scanner(file)) {

      while (sc.hasNextLine()) {
        line = sc.nextLine().toLowerCase();
        wordArr = line.split(" ");
        for(int i=0;i<wordArr.length; i++){
          index++;
          returnTree.put(wordArr[i], index);
        }
      }
      return returnTree;
    } catch (Exception e){
      System.out.println("ERROR: Did not file file at this location");
    }
    return returnTree;
  }
}
