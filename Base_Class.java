
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Purpose: Hold the main method and manage the operations of the subordinate
 * classes UMGC CMSC 495 Special Topics Developer: Team 1 Date: February 12,
 * 2021
 */
public class Base_Class {

    /**
     * Instance and Field variables
     */
    public Boolean returningUser = false;
    public String userName;
    public int loginCount = 0;
    public int loyaltyPoints = 0;
    public String localDateString;
    public String localTimeString;
    public Boolean rejectForm = false;
    public int creditCardNumber = 0;
    public String ccDate;
    public int cvvCode = 999;
    public String password;
    public Boolean validForm = false;

    /**
     * Constructors
     */
    public Base_Class() {
    }

    /* I will keep adding to this constructor as we figure out what we need to
    send between classes
     */
    public Base_Class(int loyaltyPoints) {
        loyaltyPoints = this.loyaltyPoints;
    }

    /**
     * Getters
     */
    /**
     * Setters
     */
    /**
     * Methods
     */
    public void existingUserCheck() {
//        if userName matches a userName in the database {
//        returningUser = true;
//    }
    }

    public void validateWelcomeMessage() {
        if (returningUser == true) {
            JOptionPane.showMessageDialog(null, "Welcome back " + userName);
        }
    }

    public void calculateLoyaltyPoints() {
        if (returningUser == true) {
//            query the database for the number of logins
//                    loginCount == the number of logins
//                            loyaltyPoints = loginCount + 10;
        }
    }

    public void dateAndTime() {
        LocalDate localDate = LocalDate.now();
        localDateString = localDate.toString();
        LocalTime localTime = LocalTime.now();
        localTimeString = localTime.toString();
    }

    public void recordFormData() {
        // use this to obtain data from the form
    }

    public void validateFormData() {
        if (returningUser == false) {
            if (userName.length() == 0) {
                JOptionPane.showMessageDialog(null, "Invalid userName, userName cannot be blank");
                rejectForm = true;
            } else if (userName.length() >= 129) {
                JOptionPane.showMessageDialog(null, "Invalid userName, userName cannot be more than 128 characters");
                rejectForm = true;
            } else if (creditCardNumber >= 0) {
                int ccn = String.valueOf(creditCardNumber).length();
                if (ccn <= 15) {
                    JOptionPane.showMessageDialog(null, "Invalid credit card number, the credit card number must be 16 digits");
                    rejectForm = true;
                } else if (ccn >= 17) {
                    JOptionPane.showMessageDialog(null, "Invalid credit card number, the credit card number must be 16 digits");
                    rejectForm = true;
                } else if (ccn > 0) {
                    String cCNString = Integer.toString(ccn);
                    Pattern regex = Pattern.compile("[^A-Za-z0-9]");
                    Matcher matcher = regex.matcher(cCNString);
                    boolean matches = matcher.matches();
                    if (cCNString.contains(".")) {
                        JOptionPane.showMessageDialog(null, "Invalid credit card number, the credit card number cannot contain a decimal");
                        rejectForm = true;
                    } else if (matches == false) {
                        JOptionPane.showMessageDialog(null, "Invalid credit card number, the credit card number cannot contain a special characters");
                        rejectForm = true;
                    }
                }
            } else if (ccDate.length() > 0) {
                Pattern regex = Pattern.compile("[^A-ZA-ZA-Z]" + " " + "[^0-90-90-90-9]");//removed day from expiration date. Automatically assumes las day of the month
                Matcher matcher = regex.matcher(ccDate);
                boolean matches = matcher.matches();
                if (matches == false) {
                    JOptionPane.showMessageDialog(null, "Invalid credit card date format, the date format is MMM YYYY");
                    rejectForm = true;
                }//removed CVV code -> not allowed to have except at POS
            } else if (Security_Class.passwordTest(password)==Status.TOO_SHORT) {
                JOptionPane.showMessageDialog(null, "Invalid password, password must be at least 8 characters");
                rejectForm = true;
            } else if (Security_Class.passwordTest(password)==Status.TOO_LONG) {
                JOptionPane.showMessageDialog(null, "Invalid password, password must be less than or equal to 128 characters");
                rejectForm = true;
            } else if Security_Class.passwordTest(password)==Status.BREACHED) {// query the database to see if it is in the list of common passwords
                JOptionPane.showMessageDialog(null, "Invalid password, password is found on a list of common passwords");
                rejectForm = true;
            } else {
                validForm = true;
                JOptionPane.showMessageDialog(null, "Welcome " + userName);
            }

        }
    }

    public void storeFormDataInSQLDatabase() {
        if (validForm == true) {
            // send userName to the database;
            // send loginCount  to the database;
            // send loyaltyPoints to the database;
            // send localDateString to the database?;
            // send localTimeString to the database?;
            // send creditCardNumber to the database;
            // send ccDate to the database;
            // --> should not send cvvCode to the database; not permitted to store CVV number
            // send password hash to the database;
            String hash = Security_Class.getHash(password);//salt is included in this string; no need to separate.
        }
    }

    public void sendEmail() {
        if (validForm == true) {
            // tell Email_Engine to send the email
        }
    }

    public void assignAccountNumber() {
        if (validForm == true) {
            // query the database to find database length
            // the account number is database length + 1
        }
    }

    public void deleteUser() {
    }

    public static void main(String[] args) {

        /**
         * Instantiate the GUI
         */
        // constructor in GUI must provide the userName
//        GUI gui = new GUI(userName, creditCardNumber);
//        this.userName = userName;
        //this.creditCardNumber = creditCardNumber;
        /**
         * Instantiate the Database_Class
         */
        Database_Class db = new Database_Class();

        /**
         * Instantiate the security features
         */
        //Security_Class sc = new Security_Class();
        //Commented out because security features will be static methods
        /**
         * Instantiate the Email_Engine
         */
        Email_Engine ee = new Email_Engine();

    }

}
