import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AllFiles {
    //Attributes


    //Constructor
    public AllFiles() {
        findFiles();
    }

    //Methods
    /*
     *   Finds all files
     */
    public void findFiles() {
        File myPath = new File("C:\\Programmering2\\Filhantering\\src"); //Writes out every file in this map.
        String[] allFiles = myPath.list(); //List of all files in allFiles
        for (String filenames : allFiles) { //For everything in allFiles
            System.out.println(filenames);
        }
    }

    /*
    *   To find the longest word in our textfile "words.txt"
    */
    public void longestWordInWords() {
        try {
           Scanner sc = new Scanner(new File("C:\\Programmering2\\Filhantering\\src\\words.txt"));
        } catch (IOException e) {
            System.out.println("File 'words.txt' not found");
        }

    }
}
