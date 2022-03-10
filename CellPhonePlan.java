// Import the Scanner
import java.util.*;

/**
 * In this program we are creating a system that allows students to sign up for a cell phone plan,
 * either an individual plan or in a group of up to 3 students
 * students must sign up for the plan between 1/10/22 and 3/11/22 
 * the students are given four different data plan choices to choose from,
 * and the cost of the plan is calculated
 *
 * @author Nash Lawrence
 */
public class CellPhonePlan {
    
    /** defines the minimum month (1) allowed to be input */ 
    public static final int MIN_MONTH = 1;
    
    /** defines the maximum month (3) allowed to be input */
    public static final int MAX_MONTH = 3;
    
    /** defines the minimum day (1) allowed to be input */
    public static final int MIN_DAY = 1;
    
    /** defines the maximum day (30) allowed to be input */
    public static final int MAX_DAY = 30;
    
    /** defines the minimum number of students (2) that can be in a group */
    public static final int MIN_GROUP = 2;
    
    /** defines the maximum number of students (3) that can be in a group */
    public static final int MAX_GROUP = 3;
    
    /** defines the per month cost of an individual 4G plan */
    public static final int SINGLE_FOUR = 15;
    
    /** defines the per month cost of an individual 10G plan */
    public static final int SINGLE_TEN = 20;
    
    /** defines the per month cost of an individual 15G plan */
    public static final int SINGLE_FIFTEEN = 25;
    
    /** defines the per month cost of an individual Unlimited plan */
    public static final int SINGLE_UNLIMITED = 30;
    
    /** defines the per month cost of a 4G plan with two students */
    public static final int DOUBLE_FOUR = 10;
    
    /** defines the per month cost of a 10G plan with two students */
    public static final int DOUBLE_TEN = 15;
    
    /** defines the per month cost of a 15G plan with two students */
    public static final int DOUBLE_FIFTEEN = 20;
    
    /** defines the per month cost of a Unlimited plan with two students */
    public static final int DOUBLE_UNLIMITED = 25;
    
    /** defines the per month cost of a 4G plan with three students */
    public static final int TRIPLE_FOUR = 5;
    
    /** defines the per month cost of a 10G plan with three students */
    public static final int TRIPLE_TEN = 10;
    
    /** defines the per month cost of a 15G plan with three students */
    public static final int TRIPLE_FIFTEEN = 15;
    
    /** defines the per month cost of an Unlimited plan with three students */
    public static final int TRIPLE_UNLIMITED = 20;
    
    /** defines the amount of months the data plan covers */
    public static final int NUM_MONTHS = 3;
    
    /**
     * Enter a display header message with instructions for the cell phone plan
     * Make inputs for students to choose what type of plan they want
     * call methods from main to test the users inputs 
     * @param args command line arguments (not used)
     *
     */
    public static void main(String[] args) {
        // Put scanner keyboard in for inputs and display the header message
        Scanner scnr = new Scanner(System.in);
        System.out.println("\tWelcome to the Wolfpack Cell Phone Company!");
        System.out.println("We offer 90 day individual and group plans for up to 3 students.");
        System.out.println("Plans must start between Jan 10 and Mar 11, 2022. You may choose");
        System.out.println("from data plans offering 4, 10, 15, or unlimited GB per month!");
        System.out.println("When prompted, please enter the start date, whether it is a group");
        System.out.println("plan and the number of students in the group, and your data plan");
        System.out.println("choice. Your total plan cost and end date will then be output.");
        System.out.println();
        
        // Declare int variables to be input by user and call isValidDate method to test our inputs
        int startMonth;
        int startDay;
        System.out.print("Start date (eg. 3 10): ");
        startMonth = scnr.nextInt();        
        startDay = scnr.nextInt();        
        
        if (isValidDate(startMonth, startDay) == false) {
            System.out.print("Invalid date");
            System.exit(1);
        }        
        
        // Declare String variable to be input by user 
        // Declare integer variable to be input by user if it is a group plan
        String groupPlan;
        int numStudents = 0;
        System.out.print("Group plan (y,n): ");
        groupPlan = scnr.next();
        
        // Input nested if statement to determine if it is a group plan
        // or not and make sure the group number is valid 
        if ((groupPlan.indexOf('y') == 0) || (groupPlan.indexOf('Y') == 0)) {
            System.out.print("Number of students: ");
            numStudents = scnr.nextInt();
            if ((numStudents < MIN_GROUP) || (numStudents > MAX_GROUP)) {
                System.out.print("Invalid number");
                System.exit(1);
            }
        }
            
        // Declare String variable to be input by user and
        // call the method isValidPlan to test if the inputs are valid
        String dataPlan;
        System.out.print("Data plan (4, 10, 15, U): ");
        dataPlan = scnr.next();
        
        if (isValidPlan(dataPlan) == false) {
            System.out.print("Invalid plan");
            System.exit(1);
        }
        // Print a newline, followed by the Plan cost and call
        // the getPlanCost method to determine the plan Cost
        // based on the input by the user
        System.out.println();
        System.out.print("Plan cost: $");
        System.out.print(getPlanCost(numStudents, dataPlan));
        System.out.print(".00");
        
        // Print a newline, followed by the End date
        // and call the getEndDate method to determine the end date
        // based on the input by the user
        System.out.println();
        System.out.print("End date: ");
        System.out.print(getEndDate(startMonth, startDay));
    }
    
    /**
     * determines if the month and day input by the user is within the range 1/10/22-3/11/22
     * @param month the numbered month the user inputs 
     * @param day the numbered day the user inputs 
     * @return true if the user input is within the given range of dates, false if not 
     */
    public static boolean isValidDate(int month, int day) {
        boolean validDate = true;
        
        if ((month < MIN_MONTH) || (month > MAX_MONTH)) {
            validDate = false;
        }
        else if ((day < MIN_DAY) || (day > MAX_DAY)) {
            validDate = false;            
        }
        else if (month == MIN_MONTH) {
            if (day < 10) {
                validDate = false;
            }
        }
        else if (month == MAX_MONTH) {
            if (day > 11) {
                validDate = false;
            }
        }
        else if (month == 2) {
            if (day > 28) {
                validDate = false;
            }
        }
        else {
            validDate = true;
        }
        return validDate;                
    }
    
    /**
     * determines if the data plan input by the user equals "4", "10", "15", "U", or "u"
     * @param dataPlan the string input by the user to choose their specific data plan 
     * @return true if the user input is one of the five data plan strings given, false if not 
     */
    public static boolean isValidPlan(String dataPlan) {
        boolean validPlan = true;
        
        if ((dataPlan.equals("4")) || (dataPlan.equals("10")) || (dataPlan.equals("15"))) {
            validPlan = true;
        }
        else if ((dataPlan.equals("U")) || (dataPlan.equals("u"))) {
            validPlan = true;
        }
        else {
            validPlan = false;
        }
        return validPlan;                
    }
    
    /**
     * calculates the total cost of the users data plan depending on their inputs 
     * @param numberOfStudents the amount of students in a group
     * if the user decides to be in a group 
     * @param dataPlan the string input by the user
     * to choose their specific data plan
     * @return the total cost of the chosen data plan
     * @throws IllegalArgumentException "Invalid plan"
     * if the plan is invalid
     * @throws IllegalArgumentException "Invalid number"
     * if numberOfStudents is less than 1 or greater than 3
     */
    public static int getPlanCost(int numberOfStudents, String dataPlan) {
        int totalCost = 0;
        
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("4")) && (numberOfStudents != 3) && (numberOfStudents != 2)) {
            totalCost = (SINGLE_FOUR * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("10")) && (numberOfStudents != 3) && (numberOfStudents != 2)) {
            totalCost = (SINGLE_TEN * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("15")) && (numberOfStudents != 3) && (numberOfStudents != 2)) {
            totalCost = (SINGLE_FIFTEEN * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("U")) && (numberOfStudents != 3) && (numberOfStudents != 2)) {
            totalCost = (SINGLE_UNLIMITED * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("u")) && (numberOfStudents != 3) && (numberOfStudents != 2)) {
            totalCost = (SINGLE_UNLIMITED * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("4")) && (numberOfStudents == 2)) {
            totalCost = (numberOfStudents * DOUBLE_FOUR * NUM_MONTHS);
        }        
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("4")) && (numberOfStudents == 3)) {
            totalCost = (numberOfStudents * TRIPLE_FOUR * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("10")) && (numberOfStudents == 2)) {
            totalCost = (numberOfStudents * DOUBLE_TEN * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("10")) && (numberOfStudents == 3)) {
            totalCost = (numberOfStudents * TRIPLE_TEN * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("15")) && (numberOfStudents == 2)) {
            totalCost = (numberOfStudents * DOUBLE_FIFTEEN * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("15")) && (numberOfStudents == 3)) {
            totalCost = (numberOfStudents * TRIPLE_FIFTEEN * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("u")) && (numberOfStudents == 2)) {
            totalCost = (numberOfStudents * DOUBLE_UNLIMITED * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("u")) && (numberOfStudents == 3)) {
            totalCost = (numberOfStudents * TRIPLE_UNLIMITED * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("U")) && (numberOfStudents == 2)) {
            totalCost = (numberOfStudents * DOUBLE_UNLIMITED * NUM_MONTHS);
        }
        if ((isValidPlan(dataPlan) == true) && (dataPlan.equals("U")) && (numberOfStudents == 3)) {
            totalCost = (numberOfStudents * TRIPLE_UNLIMITED * NUM_MONTHS);
        }
        return totalCost;
    }

    /**
     * Determines the cell phone plan end date
     * that is 89 days later than the given month/day in 2022
     * Returns the end date as a String in which
     * the month, day, and year, 22, are separated by a 
     * forward slash, "/", for example "4/21/22"
     * @param month gives the number month that the data plan ends,
     * based on the date the plan starts
     * @param day gives the number day that the data plan ends,
     * based on the date the plan starts
     * @return the end date as a String formatted month/date/year
     * @throws IllegalArgumentException "Invalid date", if the date is invalid 
     */
    public static String getEndDate(int month, int day) {
        String endDate = " ";
        
        if ((isValidDate(month, day) == true) && (month == MIN_MONTH)) {
            month = month + 3;
            day = day - 1;
            endDate = month + "/" + day + "/" + "22";
        }
        if ((isValidDate(month, day) == true) && (month == 2)) {
            month = month + 3;
            endDate = month + "/" + day + "/" + "22";
        }
        if ((isValidDate(month, day) == true) && (month == MAX_MONTH) && (day < 4)) {
            month = month + 2;
            day = day + 28;
            endDate = month + "/" + day + "/" + "22";
        }
        if ((isValidDate(month, day) == true) && (month == MAX_MONTH) && (day >= 4)) {
            month = month + 3;
            day = day - 3;
            endDate = month + "/" + day + "/" + "22";
        }
        return endDate;
        
    }
        
} 
     