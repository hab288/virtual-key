package VirtualKey;

import java.util.Scanner;

public class MenuController {

    // Welcome message
    public static void displayWelcomeMessage(String developler_name, String applicatin_name, String date){
        System.out.println("\n#########################################  Welcome to " + applicatin_name + " Application ########################################");
        System.out.println("                                                Developer Name: " + developler_name + "                                            ");
        System.out.println("                                                  Date: " + date + "                                                   ");
        System.out.println("             The purpose of this application is to add new file, to search added file, and to delete added file from MainFolder          ");
        FileController.createNewFolder("MainFolder");
        firstMenu();
    }


    // First menu display
    public static void firstMenu() {
        System.out.println("\n########################### First Menu   ############################" );
        System.out.println("   ======> 1, To display all files, press 1" );
        System.out.println("   ======> 2, To go to second menu, press 2" );
        System.out.println("   ======> 3, To quite this application, press 3" );

        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                int input_choice = scan.nextInt();
                switch (input_choice) {
                    case 1:
                        FileController.displayAllFiles();
                        firstMenu();
                        break;
                    case 2:
                        secondMenu();
                        break;
                    case 3:
                        System.out.println("\n Exited from application! \n");
                        scan.close();
                        System.exit(0);
                    default:
                        System.out.println("   Enter a valid input 1 - 3 only!");
                }
            } catch (Exception e) {
                System.out.println("   Enter a valid input 1 - 3 only!");
                System.out.println(e.getClass().getName());
                firstMenu();
            }

        }
    }

    // Second menu display
    public static void secondMenu(){
        System.out.println("\n########################### Second Menu   ############################" );
        System.out.println("   ======> 1, To add file, press 1" );
        System.out.println("   ======> 2, To delete file, press 2" );
        System.out.println("   ======> 3, To search file, press 3" );
        System.out.println("   ======> 4, To got back to first menu, press 4" );

        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                int input_choice = scan.nextInt();
                switch (input_choice) {
                    case 1:
                        System.out.println("   ======> Enter file name you would like to add");
                        String input_choice_to_add = scan.next();
                        FileController.addFile(input_choice_to_add);
                        secondMenu();
                        break;
                    case 2:
                        System.out.println("   ======> Enter file name you would like to delete");
                        String input_choice_to_delete = scan.next();
                        FileController.deleteFile(input_choice_to_delete);
                        secondMenu();
                        break;
                    case 3:
                        System.out.println("   ======> Enter file name you would like to search");
                        String input_choice_to_search = scan.next();
                        FileController.searchFile(input_choice_to_search);
                        secondMenu();
                        break;
                    case 4:
                        System.out.println("   Back to First Menu");
                        firstMenu();
                       return;
                    default:
                        System.out.println("   Enter a valid input 1 - 4 only!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(" Enter a valid input 1 - 4 only!");
                System.out.println(e.getClass().getName());
                secondMenu();
            }

        }
    }
}
