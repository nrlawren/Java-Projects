// Import the Scanner
import java.util.*;

/**
 * This program prompts the user to choose between printing an Address label
 * and an Event ticket, or simply quitting to exit the program.
 * Depending on whether the user chooses the Address label or event ticket option,
 * they will be prompted to input more information. If all input is valid
 * the program will print the Address label or Event ticket
 *
 * @author Nash Lawrence
 */
public class PrintShop {
    
     /** defines the number to plug into the equation "width - 5" */
     public static final int PLUG_IN = 5;
     
     /** defines the minimum width that can be input */
     public static final int MIN_WIDTH = 15;
     
     /** defines the maximum width that can be input */
     public static final int MAX_WIDTH = 55;
    
        
    
    /**
     * create inputs for the user to decide whether they are printing and
     * address label or event ticket, then prompt them for the rest of the 
     * information depending on their choice. If any of the input by the user
     * is invalid, print the error handling message and redisplay the header
     * letting the user try again without exiting the program. Only exit the program 
     * if the user selects quit. If all inputs are valid, call the methods to print 
     * the ticket or label
     * @param args command line arguments (not used)
     *
     */
    public static void main(String[] args) {
        // Put Scanner keyboard in for user inputs
        Scanner scnr = new Scanner(System.in);
        // create variables for user input and to call the methods
        String optionChoice;
        boolean isValid = true;
        // create variables for user input for option A/a 
        int labelWidth;
        String userName;
        String userAddy;
        String userCity;
        String userState;
        String userZip;
        // create variables for user input for option T/t
        int ticketWidth;
        String orgName;
        String eventName;
        String eventDate;
        String eventLocation;
        
        // Create a do-while loop to redisplay the menu after invalid input until the user chooses to quit
        do {            
            System.out.println("Print Shop - Please choose an option.\n");
            System.out.println();
            System.out.println("A - Address Label");
            System.out.println("T - Event Ticket");
            System.out.println("Q - Quit\n");
            System.out.println();
            System.out.print("Option: ");
            optionChoice = scnr.next();
            if (optionChoice.equalsIgnoreCase("q")) {
            System.exit(1);
            }
            else if (optionChoice.equalsIgnoreCase("A")) {
                System.out.print("Width: ");
                labelWidth = scnr.nextInt();
                scnr.nextLine();
                if ((labelWidth < MIN_WIDTH) || (labelWidth > MAX_WIDTH)) {
                    System.out.println("Invalid width\n");
                    isValid = false;
                }
                else {
                    System.out.print("Name: ");
                    userName = scnr.nextLine();
                    if (userName.length() > (labelWidth - 2)) {
                        System.out.println("Too long\n");
                        isValid = false;
                    }
                    else {
                        System.out.print("Street Address: ");
                        userAddy = scnr.nextLine();
                        if (userAddy.length() > (labelWidth - 2)) {
                            System.out.println("Too long\n");
                            isValid = false;
                        }
                        else {
                            System.out.print("City: ");
                            userCity = scnr.nextLine();
                            System.out.print("State: ");
                            userState = scnr.nextLine();
                            System.out.print("Zipcode: ");
                            userZip = scnr.nextLine();
                            if ((userCity.length() + userState.length() + userZip.length()) > (labelWidth - PLUG_IN)) {
                                System.out.println("Too long\n");
                                isValid = false;
                            }
                            else {
                                System.out.printf(top(labelWidth));
                                System.out.println();
                                userName = userName.toUpperCase();
                                System.out.printf(center(labelWidth, userName));
                                System.out.println();
                                System.out.printf(center(labelWidth, userAddy));
                                System.out.println();
                                userState = userState.toUpperCase();
                                System.out.printf(center(labelWidth, userCity.concat(", " + userState + " " + userZip)));
                                System.out.println();
                                System.out.printf(bottom(labelWidth));
                                System.out.println("\n");                            
                                isValid = false;                            
                            }
                        }
                    }
                }
            }
            else if (optionChoice.equalsIgnoreCase("t")) {
                System.out.print("Width: ");
                ticketWidth = scnr.nextInt();
                scnr.nextLine();
                if ((ticketWidth < MIN_WIDTH) || (ticketWidth > MAX_WIDTH)) {
                    System.out.println("Invalid width\n");
                    isValid = false;
                }
                else {
                    System.out.print("Organization: ");
                    orgName = scnr.nextLine();
                    if (orgName.length() > (ticketWidth - 2)) {
                        System.out.println("Too long\n");
                        isValid = false;
                    }
                    else {
                        System.out.print("Event Name: ");
                        eventName = scnr.nextLine();
                        if (eventName.length() > (ticketWidth - 2)) {
                            System.out.println("Too long\n");
                            isValid = false;
                        }
                        else {
                            System.out.print("Date/Time: ");
                            eventDate = scnr.nextLine();
                            System.out.print("Location: ");
                            eventLocation = scnr.nextLine();
                            if ((eventDate.length() + eventLocation.length()) > (ticketWidth - 2)) {
                                System.out.println("Too long\n");
                                isValid = false;
                            }
                            else {
                                System.out.printf(top(ticketWidth));
                                System.out.println();
                                System.out.printf(center(ticketWidth, orgName));
                                System.out.println();
                                System.out.printf(blankLine(ticketWidth));
                                System.out.println();
                                eventName = eventName.toUpperCase();
                                System.out.printf(center(ticketWidth, eventName));
                                System.out.println();
                                System.out.printf(blankLine(ticketWidth));
                                System.out.println();
                                System.out.printf(leftRightJustify(ticketWidth, eventDate, eventLocation));
                                System.out.println();
                                System.out.printf(bottom(ticketWidth));
                                System.out.println("\n");
                                isValid = false;
                            }
                        }
                    }
                }
            }
            else {
                System.out.println("Invalid option\n");
                isValid = false;
            }            
        } while (!isValid == true);
    }
                
    /**
     * makes a string that contains a space followed by (width -2) underscores
     * followed by a newline character, which is then followed by a forward 
     * slash followed by (width - 2) spaces followed by a backslash
     * @param width determines how many underscores and spaces will be printed
     * in the string
     * @return a string which represents the top of a label/ticket
     * @throws IllegalArgumentException "Invalid width" if width is less than two
     *
     */
    public static String top(int width) {
        String topLine = " ";
        String secondLine = "";
        int i = 0;
        while (i < (width - 2)) {
            topLine += "_";
            secondLine += " ";
            i++;
        }
        secondLine = "/" + secondLine + "\\";
        return topLine + "\n" + secondLine;
    }    
            
    /**
     * makes a string that contains a backslash followed by (width - 2) 
     * underscores, followed by a forward slash
     * @param width determines how many underscores will be printed
     * in the string
     * @return a string that represents the bottom of a label/ticket
     * @throws IllegalArgumentException "Invalid width" if width is less than two
     *
     */
    public static String bottom(int width) {
        String bottomLine = "";
        int i = 0;
        while (i < (width - 2)) {
            bottomLine += "_";
            i++;
        }
        return "\\" + bottomLine + "/";
    }

    /**
     * makes a string that contains a vertical bar followed by the
     * length, followed by another vertical bar at the end
     * @param width determines how many spaces will be printed
     * in between the vertical bars
     * @return a string of the given length with vertical bars at 
     * the beginning and end with spaces in between them
     * @throws IllegalArgumentException "Invalid width" if width is
     * less than two
     *
     */
    public static String blankLine(int width) {
        String lineBlank = "";
        int i = 0;
        while (i < (width - 2)) {
            lineBlank += " ";
            i++;
        }
        return "|" + lineBlank + "|";
    }

    /**
     * makes a string with vertical bars at the beginning and end
     * with the String item centered in between them
     * @param width determines the length between the vertical bars
     * @param item is the string to be printed and centered in 
     * between the vertical bars on both sides
     * @return a string of the given width with vertical bars at the 
     * beginning and end, and the string item centered between them.
     * If the string item cannot be centered exactly, the centered 
     * item should have one more character to the left of center than
     * it has on the right
     * @throws IllegalArgumentException "Invalid width" if width is 
     * less than two
     * @throws IllegalArgumentException "Too long" if the length of 
     * the item is greater than (width - 2) 
     *
     */
    public static String center(int width, String item) {
        String textCenter = "";
        int i = 0;
        
        if ((width - 2) - item.length() % 2 == 0) {
            for (i = 0; i < ((width - 2) - (item.length())) / 2; i++) {
            textCenter += " ";
            }
            return "|" + textCenter + item + textCenter + "|";
        }
        else {
            for (i = 0; i < ((width - 2) - (item.length())) / 2; i++) {
            textCenter += " ";
            }
            return "|" + textCenter + item + textCenter + "|";
        }
    }

    /**
     * makes a string containing vertical bars at the beginning and end,
     * with the left item after the first bar and the right item before
     * the last bar and spaces
     * @param width determines the length between the vertical bars
     * @param leftItem is the string to be printed after the first bar
     * @param rightItem is the string to be printed before the last 
     * vertical bar and spaces, if necessary
     * @return a string of the given width with vertical bars at the 
     * beginning and end, with the left item printed after the first
     * vertical bar and the right item printed before the last vertical
     * bar and spaces, if necessary between them
     * @throws IllegalArgumentException "Invalid width" if width is less
     * than two
     * @throws IllegalArgumentException "Too long" if the combined length 
     * of the left and right items is greater than (width - 2)
     *
     */
    public static String leftRightJustify(int width, String leftItem, String rightItem) {
        String rightLeft = "";
        int i = 0;
        
        for (i = 0; i < (width - 2) - leftItem.length() - rightItem.length(); i++) {
            rightLeft += " ";
        }
        return "|" + leftItem + rightLeft + rightItem + "|";
    }
}
    