package Controllers;

import TransferPack.Transfer;

public class Controller {

    public static void addBankUser(String username, String password, String mobileNumber,int balance) {
        Users newUser = new Users(username, password , mobileNumber,balance);
        Users.ListOfBankUsers.add(newUser);
    }

    public static void addMobileUser(String username, String password, String mobileNumber,int balance) {
        Users newUser = new Users(username, password , mobileNumber,balance);
        Users.ListOfMobileUsers.add(newUser);
    }

    public static void addToBankSet(String userName){
        Users.setOfBankUsers.add(userName);
    }

    public static void addToMobileSet(String userName){
        Users.setOfMobileUsers.add(userName);
    }

    public static void Transfer(Transfer t)
    {
        t.TransferProcess();
    }

    public void spendMoney (int pos,char w,int cost)
    {
        if (w=='B')
        {
            Users.ListOfBankUsers.get(pos).User_Balance =  Users.ListOfBankUsers.get(pos).User_Balance - cost;
        }
        else
        {
            Users.ListOfMobileUsers.get(pos).User_Balance = Users.ListOfMobileUsers.get(pos).User_Balance - cost;

        }
    }
    public int getUser_Balance(int pos,char w)
    {
        if (w=='B')
        {
            return Users.ListOfBankUsers.get(pos).User_Balance;
        }
        else
        {
            return Users.ListOfMobileUsers.get(pos).User_Balance;

        }

    }



}
