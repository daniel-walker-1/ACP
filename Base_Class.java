
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
                    Boolean match = false;
                    if (cCNString.contains(".")) {
                        JOptionPane.showMessageDialog(null, "Invalid credit card number, the credit card number cannot contain a decimal");
                        rejectForm = true;
                    } else if (match == true) {
                        JOptionPane.showMessageDialog(null, "Invalid credit card number, the credit card number cannot contain a special characters");
                        rejectForm = true;
                    }
                }

            }

//            11. Enter the credit card date
            //            12. Enter the date wth a decimal
            //            13. Enter the date with a character
            //            14. Enter the CVV code
            //            15. Enter a 4 digit CVV code
            //            16. Enter a 2 digit CVV code
            //            17. Enter a decimal CVV code
            //            18. Enter the CVV code with a letter
            //            19. Enter a password of 8 characters
            //            20. Enter a password of 7 characters
            //            21. Enter a password of 128 characters
            //            22. Enter a password of 129 characters
            //            23. Enter a password found in the database of common passwords
        
    

        
    

        
    

        
    

        
    

    "
        }
    }

    public void storeFormDataInSQLDatabase() {
    }

    public void sendEmail() {
    }

    public void assignAccountNumber() {
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
        Security_Class sc = new Security_Class();

        /**
         * Instantiate the Email_Engine
         */
        Email_Engine ee = new Email_Engine();

    }

}
