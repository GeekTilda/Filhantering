import java.io.File;

public class AllFiles {
    //Attributes


    //Constructor
    public AllFiles() {}

    //Methods
    /*
     *   Finds all files
     */
    public void findFiles() {
        File myPath = new File("C:\\Programmering2\\Filhantering\\src"); //
        String[] allFiles = myPath.list(); //List of all files in allFiles
        for (String filenames : allFiles) { //For everything in allFiles
            System.out.println(filenames);
        }
    }
}
