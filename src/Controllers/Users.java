package Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Users {


    public static ArrayList<Users> ListOfBankUsers = new ArrayList<Users>();
    public static Set<String> setOfBankUsers = new HashSet<>();
    public static ArrayList<Users>ListOfMobileUsers = new ArrayList<Users>();
    public static Set<String> setOfMobileUsers = new HashSet<>();

    private String userName;
    private String password;
    private String mobileNumber;
    public  int User_Balance ;




    public Users() {}

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }




    public Users(String userName, String password , String mobileNumber, int user_Balance) {
        this.userName = userName;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.User_Balance = user_Balance;

    }



}
