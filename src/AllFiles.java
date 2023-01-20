import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public String[] findFiles() {
        File myPath = new File("C:\\Programmering2\\Filhantering\\src"); //Writes out every file in this map.
        String[] allFiles = myPath.list(); //List of all files in allFiles
        for (String filenames : allFiles) { //Goes through every file and writes out the name of it
            System.out.println(filenames);
        }
        return allFiles;
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
     *   CHANGE FILENAME! ****
     */
    public void createFile() {
        File myFile = new File("test.txt");
        try {
            if (myFile.createNewFile()) { //If file does not already exist
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

    /*
    *   Method for checking if file already exists!
    *   https://stackoverflow.com/questions/1816673/how-do-i-check-if-a-file-exists-in-java <- With help from
    */
    public boolean checkFile(String name) {
        File file = new File(name);
        if(file.exists() && !file.isDirectory()) { //Checks if the file exists and if it isnt the directory.
            return true;
        }
        else {
            return false;
        }
    }
    /*
    *   Clears the file of anything written in it
    */
    public void clearFile(String fileName) {
        String name = "C:\\Programmering2\\Filhantering\\src\\" + fileName; //Sets the path of the file to the one the user put in.
        try {
            FileWriter writer = new FileWriter(name,false);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Method to write data to file
     * FIX THAT IT ADDS THE FILE IF IT DOESN'T ALREADY EXIST!
     */
    public void writeToFile(String fileName) { //Needs a filename to know which file to write to
        Scanner sc = new Scanner(System.in);
        System.out.print("What do you want to write? ");
        String writing = sc.nextLine();
        String name = "C:\\Programmering2\\Filhantering\\src\\" + fileName; //Sets the path of the file to the one the user put in.
        Boolean boolie = checkFile(name);
        if (boolie == true) {
            try {
                //Filewriter will append the data in the file
                FileWriter myWriter = new FileWriter(name, true); //Created pen that lies on this file
                myWriter.write("\n" + writing); //Writes
                myWriter.close(); //Needed for it being able to stop writing!
            } catch (IOException e) {
                System.out.println("Cannot write to that file! - ERROR");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("That file does not exist! ERROR");
        }
    }

    /*
    *   Method to see all files of the same type.
    */
    public void allFilesOfTheSameType(String theFile) {
        String[] files = findFiles();
        for (int i = 0; i < files.length; i++) { //Goes through each String in files
            String file = files[i];
            String[] fileType = file.split("[.]", 2); //Splits the String after the "."
            //String fileExtension = fileType[1];
            for (int x = 0; x < fileType.length; x++) { //Goes through the array we created
                if (fileType[x].equals(theFile)) {
                    System.out.println(file + " TILDA");
                }
            }
        }
    }
    /*
    * Saves a list of people in a file, each name is on a new line.
    */
    public void peopleListMethod(ArrayList<String> peps) {
        Scanner sc = new Scanner(System.in);
        String name = "C:\\Programmering2\\Filhantering\\src\\Personer.txt";
        try {
            //Filewriter will append the data in the file
            FileWriter myWriter = new FileWriter(name, false); //Created pen that lies on this file
            for (int i = 0; i < peps.size(); i++) {
                myWriter.write(peps.get(i) + "\n"); //Writes
            }
            myWriter.close(); //Needed for it being able to stop writing!
        } catch (IOException e) {
            System.out.println("Cannot write to that file! - ERROR");
            e.printStackTrace();
        }
    }
    /*
    *   This method finds the most commonly used letter in words.txt
    */
    public void findMostCommonLetter() {
        HashMap<String, Integer> alphabet = new HashMap<>();
        try {
            Scanner sc = new Scanner(new File("C:\\Programmering2\\Filhantering\\src\\words.txt")); //Puts a scanner on our file "words.txt"
            while (sc.hasNext()) { //Looks through every new line in our text file
                String word = sc.next();
                String[] characters = word.split("");
                for (String c : characters) { //Does the loop as many times as the word has characters
                    if (Pattern.matches("[a-zA-Z]+", c)) { //Checks if the character is a letter
                        String newLetter = c.toLowerCase();
                        if (!alphabet.containsKey(newLetter)) { //Checks if the alphabet doesn't contain this letter
                            alphabet.put(newLetter, 1);
                            System.out.println(newLetter);
                        }
                        else {
                            int i = alphabet.get(newLetter) + 1;
                            alphabet.put(newLetter, i);
                        }
                    }
                }
            }
            final int[] mostCommon = {0}; //I dont even know what this is but it was needed because of "->" (Lambda)
            AtomicReference<String> mostCommonLetter = new AtomicReference<>(""); //I dont even know what this is but it was needed because of "->" (Lambda)
            alphabet.forEach((k,v) -> { //Looks through the entire alphabet
                System.out.println(k + ": " + v);
                if (alphabet.get(k) > mostCommon[0]) { //If the number is bigger than the one we already had as the biggest number of letters
                    mostCommon[0] = alphabet.get(k);
                }
            });
            for (String key : alphabet.keySet()) { //Goes through each key (String) in alphabet
                int value = alphabet.get(key);
                if (value == mostCommon[0]) {
                    mostCommonLetter.set(key);
                }
            }
            System.out.println("Most common letter is " + mostCommonLetter);
        }
        catch (IOException e) {
            System.out.println("Cannot do that! - ERROR");
            e.printStackTrace();
        }
    }
    /*
    * Find all mail-adresses on website and save these in txt file
    */
    public void findEmail() {
        try {
            URL url = new URL("https://sms.schoolsoft.se/nti/jsp/student/right_student_staff.jsp?menu=contactlist");
            Scanner sc = new Scanner(url.openStream());

            StringBuffer cont = new StringBuffer();

            while (sc.hasNext()) {
                cont.append(sc.next());
            }
            String emails = cont.toString();
            Pattern pattern = Pattern.compile("([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])");
            Matcher matcher = pattern.matcher(emails);

            FileWriter fileWriter = new FileWriter("emails.txt", false);
            Set set = new HashSet();
            while (matcher.find()) {
                if (set.add(matcher.group())) {
                    fileWriter.write(matcher.group() + "\n");
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}
