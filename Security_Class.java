
/** Purpose: Hold the class containing the application security features
 *  UMGC CMSC 495 Special Topics
 *  Developer: Team 1
 *  Date: February 12, 2021
 */
// import statements
import com.codahale.passpol.*;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


public class Security_Class {

    /**
     * Instance and Field variables
     */
    /**
     * Constructors
     */
    public Security_Class() {
    }

    //Method for testing passwords against minimum and maximum length and list of known
    //breached passwords. Needs passpol dependency to run. Returns enumerated Status 
    //of either "BREACHED", "TOO_SHORT", "TOO_LONG" or "OK". Passwords returning the 
    //"OK" status are good to pass to the hashing algorithm.
    public static Status passwordTest(String password) {
        BreachDatabase bdb = BreachDatabase.top100K();//Import database of breached passwords
        final PasswordPolicy policy = new PasswordPolicy(bdb, 8, 128);//create policy using breached passwords, min length = 8, max length = 128
        return policy.check(password);
    }//end passwordTest method

    //Method for salt/hashing password. Requires Argon2 POM dependency
    public static String passwordHash(String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);//forces Argon2id algorithm instead of default argon2i
        String hash = argon2.hash(4, 1024 * 1024, 8, password);//parameters here require approx 1 gig of memory and 1 second on a PC to hash
        //boolean success = argon2.verify(hash, password);
        return hash;
    }//End passwordHash method
    
    //Method to verify a password against a stored hash. Hash by default contains the salt used upon generation; do not alter from what is retrieved from database
    //returns true if password matches stored hash value, otherwise false
    public static boolean checkPassword(String password, String Hash) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);//forces Argon2id algorithm instead of default argon2i
        boolean success = argon2.verify(hash, password);
        return success;
    }//End checkPassword method
    
    /**
     * Getters
     */
    /**
     * Setters
     */
    /**
     * Methods
     */
    public void performSalt() {
    }

    public void performHash() {
    }
}
