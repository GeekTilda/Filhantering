public class Main {
    public static AllFiles allFiles = new AllFiles(); //Makes one AllFiles object so that we can refer to it later
    public static void main(String[] args) {
        AllFiles allFiles = new AllFiles();
        //while (true) {
        //    menu();
        //}
    }
    /*
    * Menu method. Will ask the client for its next move after everything is done.
    * Lists all things that the client can do and will then move on to a switch.
    */
    public static void menu() {
        System.out.println("------MENY------");
        System.out.println("1. List all files");
        System.out.println("2. List all files of same type");
        System.out.println("3. Find longest word in words.txt file");
        System.out.println("4. Find most common letter in file..."); //-> list all files
        System.out.println();
        int i = 0;
        /*
        * All the different cases that happen regarding what the user chose above.
        */
        switch (i) {
            case 1:
                allFiles.findFiles();
            case 2:
        }
    }
}