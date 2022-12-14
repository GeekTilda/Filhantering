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
        for (String filenames : allFiles) { //Goes through every file and writes out the name of it
            System.out.println(filenames);
        }
    }

    /*
    *   To find the longest word in our textfile "words.txt"
    *   https://www.w3resource.com/java-exercises/io/java-io-exercise-18.php By help from this c:
    */
    public void longestWordInWords() {
        String longestWord = "";
        String currentWord = "";

        try {
           Scanner sc = new Scanner(new File("C:\\Programmering2\\Filhantering\\src\\words.txt"));
            while (sc.hasNext()) { //Looks through every new line in our text file
                currentWord = sc.next();
                if (currentWord.length() > longestWord.length()) { //Checks if our current word is longer than the word we already have.
                    longestWord = currentWord;
                }
            }
            System.out.println();
            System.out.println("The longest word in the English dictionary is: " + longestWord + "!");
            System.out.println();
        }
     catch (IOException e) {
            System.out.println("File 'words.txt' not found");
        }
    }

    /*
     *   Create a new file if the file does not already exist
     */
    public void createFile() {
        File myFile = new File("test.txt");
        try {
            if (myFile.createNewFile()) { //If file does not already exits
                System.out.println("File added");
            }
            else { //If file already exists
                System.out.println("File already exists");
            }
        } catch (IOException e) { //Input output exception
            System.out.println("Can't do - ERROR");
            e.printStackTrace();
        }
    }
}
