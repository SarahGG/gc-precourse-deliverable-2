import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Prints the number of years, months, and days
 * between two given dates.
 *
 * @author Sarah Guarino
 * @version 1.0
 */

/**
 *
 */
public class Deliverable2{

    private static ArrayList<LocalDate> userDates = new ArrayList<LocalDate>(); //FIXME: Strange error when I tried to initialize this in the constructor
    // temporary memory for user input dates
    private static int userYear = 0;
    private static int userMonth = 0;
    private static int userDay = 0;


    /**
     * Default Constructors for Deliverable2
     */
    public Deliverable2() {
        userYear = 0;
        userMonth = 0;
        userDay = 0;
    }


    /**
     * Asks for a date, reads three integers,
     * then turns them into a LocalDate object
     *
     * @param datePrompt what to print when prompting user for a date
     */
    private static void getUserNumber(String datePrompt) {
        Scanner scnr = new Scanner(System.in);

        // Uses the prompt datePrompt to ask for a date
        System.out.print(datePrompt);

        // Collects the next three integers in temporary fields
        userYear = scnr.nextInt();
        userMonth = scnr.nextInt();
        userDay = scnr.nextInt();

        // Converts those numbers and changes them into a userDates LocalDate element
        userDates.add(LocalDate.of(userYear, userMonth, userDay));
    }


    /**
     * Checks two dates, and switches them
     * if they are not chronological
     */
    private static void makeChronological() {

        // is "true" if userDates(0) is later than userDate(1)
        if ( 1 < userDates.get(0).compareTo(userDates.get(1)) ) {

            // Creates a temporary 'switching' element, initializes it to 00s
            userDates.add(LocalDate.of(0000,01,01));

            // Performs the switch so that the two dates are chronological
            userDates.set(2, userDates.get(0));
            userDates.set(0, userDates.get(1));
            userDates.set(1, userDates.get(2));

            // Removes the extra userDates element
            userDates.remove(2);
        }
    }

    /**
     * Asks for two dates, then prints the time between
     * the two dates in years, months, and days.
     *
     * @param args command-line arguments
     */
    public static void main (String[] args) {

        // defining and initializing my variables
        Scanner scnr = new Scanner(System.in);
        String firstDatePrompt = "Please enter your first date (ie: 000Y 0M 0D): ";
        String secondDatePrompt = "Please enter your second date (ie: 000Y 0M 0D): ";
        Period dateDiff;

        // Get two dates from the user, passing a prompt string as an argument
        // getUserNumber delivers the prompt, then translates the input to a date
        getUserNumber(firstDatePrompt);
        getUserNumber(secondDatePrompt);

        // Compares the users dates, and makes them chronological if they aren't already
        makeChronological();

        // gets the difference between the two dates
        dateDiff = Period.between(userDates.get(0), userDates.get(1));

        // print out the difference between the dates in days, months, and years
        System.out.printf("The time between these two dates is %d days, %d months, and %d years.", Math.abs(dateDiff.getDays()), Math.abs(dateDiff.getMonths()), Math.abs(dateDiff.getYears()));
    }
}
