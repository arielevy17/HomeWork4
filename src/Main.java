import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            RealEstate realEstate = new RealEstate();
            final int CREATE_A_ACCOUNT = 1;
            final int LOGIN = 2;
            final int POST_A_NEW_PROPERTY = 1;
            final int REMOVE_PROPERTY_ADVERTISING = 2;
            final int VIEW_ALL_PROPERTIES = 3;
            final int VIEW_USER_PROPERTIES = 4;
            final int PROPERTY_SEARCH_BY_PARAMETERS = 5;
            final int DISCONNECT_AND_RETURN_TO_THE_MAIN_MENU = 6;
            final int END_OF_PROGRAM = 3;
            int userChoose = 0;
            while (userChoose != END_OF_PROGRAM) {
                do {
                    System.out.println("Welcome to the real estate advertising management system.\n" +
                            "\n" +
                            "Please select the action you want to perform:\n" +
                            "To create a new account, press: 1\n" +
                            "To log in to an existing account, press: 2\n" +
                            "To exit the system, press: 3");
                    userChoose = scanner.nextInt();

                    switch (userChoose) {
                        case CREATE_A_ACCOUNT:
                            if (userChoose == CREATE_A_ACCOUNT) {
                                realEstate.addUser();
                            }

                        case LOGIN:
                            if (userChoose == LOGIN) {

                                User theUserNow = realEstate.userLogin();
                                if (theUserNow == null) {
                                    System.out.println("One or more of the details you entered is incorrect!");
                                    break;
                                } else {
                                    System.out.println("Choose one of the options:\n" +
                                            " To post a new property - press 1\n" +
                                            "\n" +
                                            "Remove property posting - press 2\n" +
                                            "\n" +
                                            " View all assets in the system - press 3\n" +
                                            "\n" +
                                            "View all properties posted by user - press 4\n" +
                                            "\n" +
                                            "Search for a property by parameters - press 5\n" +
                                            "\n" +
                                            "Disconnect and return to the main menu -press 6");
                                    userChoose = scanner.nextInt();
                                    switch (userChoose) {
                                        case POST_A_NEW_PROPERTY:
                                            if (userChoose == POST_A_NEW_PROPERTY) {
                                                realEstate.postNewProperty(theUserNow);
                                            }
                                        case REMOVE_PROPERTY_ADVERTISING:
                                            if (userChoose == REMOVE_PROPERTY_ADVERTISING) {
                                                realEstate.removeProperty(theUserNow);
                                            }

                                        case VIEW_ALL_PROPERTIES:
                                            if (userChoose == VIEW_ALL_PROPERTIES) {
                                                realEstate.printAllProperties();
                                            }

                                        case VIEW_USER_PROPERTIES:
                                            if (userChoose == VIEW_USER_PROPERTIES) {
                                                realEstate.printAllUserProperties(theUserNow);
                                            }

                                        case PROPERTY_SEARCH_BY_PARAMETERS:
                                            if (userChoose == PROPERTY_SEARCH_BY_PARAMETERS) {
                                                realEstate.search();
                                            }

                                        case DISCONNECT_AND_RETURN_TO_THE_MAIN_MENU:
                                            if (userChoose == DISCONNECT_AND_RETURN_TO_THE_MAIN_MENU) {
                                                break;
                                            }
                                    }
                                }
                            }
                        case END_OF_PROGRAM:
                            if (userChoose == END_OF_PROGRAM) {
                                break;
                            }
                    }
                } while (userChoose < CREATE_A_ACCOUNT || userChoose > END_OF_PROGRAM);
            }
        }
    }
