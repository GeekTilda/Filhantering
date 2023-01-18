import java.util.*;

public class Main {
    public static AllFiles allFiles = new AllFiles(); //Makes one AllFiles object so that we can refer to it later
    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    public static String askForFileType() {
        System.out.println("What file type? (ex. txt, java)");
        Scanner sc = new Scanner(System.in);
        return String.format(sc.next());
    }
    /*
     * Menu method. Will ask the client for its next move after everything is done.
     * Lists all things that the client can do and will then move on to a switch.
     */
    public static void menu() {
        int action = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("------MENY------");
        System.out.println("1. List all files");
        System.out.println("2. List all files of same type");
        System.out.println("3. Find longest word in words.txt file");
        System.out.println("4. Find most common letter in file..."); //-> list all files
        System.out.println("5. Write something in a file");
        System.out.println("6. Add people and sort a list of people"); //Does not show anything :)
        System.out.println();
        try {
            action = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Write a number!");
        }
        /*
        * All the different cases that happen regarding what the user chose above.
        */
        switch (action) {
            case 1:
                allFiles.findFiles();
            case 2:
                allFiles.allFilesOfTheSameType(askForFileType());
            case 3:
                allFiles.longestWordInWords();
            case 4:
                allFiles.findMostCommonLetter();
            case 5:
                WroteToFile();
            case 6:
                ArrayList<String> people = new ArrayList<>();
                people.add("Jonis Bonis");
                people.add("Tildis Bildis");
                people.add("Olivia Boliva");
                Collections.sort(people); //Orders it according to a->z
                allFiles.peopleListMethod(people);
        }
    }
    public static void WroteToFile() {
        Scanner sc2 = new Scanner(System.in);
        allFiles.findFiles();
        System.out.println("Which file? (ex. write '.txt' too!) ");
        String write = sc2.nextLine();
        System.out.println("Do you want to override everything already written in this file? (Yes/No)");
        String over = sc2.nextLine();
        if (over.equals("Yes")) { //If the person wanted to override and delete everything that already existed in the file.
             allFiles.clearFile(write);
        }
        allFiles.writeToFile(write);
    }

}