import java.util.Scanner;

public class Main {
    public static AllFiles allFiles = new AllFiles(); //Makes one AllFiles object so that we can refer to it later
    public static void main(String[] args) {
        //AllFiles allFiles = new AllFiles(); //JUST FOR NOW
        //allFiles.longestWordInWords();
        while (true) {
            menu();
        }
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
                allFiles.allFilesOfTheSameType("txt");
            case 3:
                allFiles.longestWordInWords();
            case 4:

            case 5:
                Scanner sc2 = new Scanner(System.in);
                allFiles.findFiles();
                System.out.println("Which file? (ex. write '.txt' too!) ");
                String write = sc2.nextLine();
                allFiles.writeToFile(write);
        }
    }
}