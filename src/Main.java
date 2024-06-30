import java.util.Objects;
import java.util.Random;
import Controllers.*;

import java.util.Scanner;

public class Main {
    public static int generateRandomBalance()
    {
        int start_Rang = 5000;
        int end_Range = 10000;
        Random r = new Random();
        return r.nextInt(end_Range - start_Rang +1 )+start_Rang;
    }
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("\nWelcome to our InstaPay System :)\n");
            System.out.println("Please choose if you are new user or have an account: ");
            System.out.println("1- New user");
            System.out.println("2- Have an account");
            System.out.println("3- Exit program");
            String choice = scanner.nextLine();

            //Register option
            if(Objects.equals(choice, "1")) {

                System.out.println("Please choose your Registration method: ");
                System.out.println("1- Bank User");
                System.out.println("2- Mobile User");
                String registerChoice = scanner.nextLine();
                //Register throw bank account number
                if (Objects.equals(registerChoice, "1")) {

                    Registration bankRegister = new BankRegister();

                    String finalBankAccount;
                    while (true) {
                        System.out.print("Enter your bank account (Must be 11 numbers or more) : ");
                        String bankAccount = scanner.nextLine();
                        if(bankAccount.length() >= 11 && bankAccount.matches("\\d+")){
                            finalBankAccount = bankAccount;
                            break;
                        }else {
                            System.out.println("Wrong Bank Account Number, Please try again");
                        }
                    }
                    String finalMobileNumber;
                    while (true) {
                        System.out.print("Enter your bank account mobile number (Must be 11 numbers): ");
                        String mobileNumber = scanner.nextLine();
                        if(mobileNumber.length() == 11 && mobileNumber.matches("\\d+")){
                            finalMobileNumber = mobileNumber;
                            break;
                        }
                        else{
                            System.out.println("Wrong Bank account Mobile Number, Please try again");
                        }
                    }
                   while(true) {

                       String verify = bankRegister.verify();
                       if (Objects.equals(verify, "Bank Account verification successful. Proceed with registration.")) {
                           System.out.println(verify);
                           String finalUserName;
                           while (true) {
                               System.out.print("Enter a username: ");
                               String username = scanner.nextLine();
                               String unique = bankRegister.checkUniqueBankUser(username);
                               if (unique.equals("AlreadyExists")) {
                                   System.out.println("Username is Already Exists please Try again");
                               } else {
                                   finalUserName = username;
                                   break;
                               }
                           }
                           System.out.print("Enter a password: ");
                           String password = scanner.nextLine();

                           bankRegister.register(finalUserName, password, finalMobileNumber,generateRandomBalance());
                           break;
                       } else {
                           System.out.println("Wrong OTP");
                       }
                   }

                    //Register throw mobile number wallet
                } else if (Objects.equals(registerChoice, "2")) {

                    Registration mobileRegister = new MobileRegister();

                    String finalMobileNumber;
                    while (true) {
                        System.out.print("Enter your mobile number with a wallet (Must be 11 numbers) : ");
                        String mobileNumber = scanner.nextLine();
                        if(mobileNumber.length() == 11 && mobileNumber.matches("\\d+")){
                            finalMobileNumber = mobileNumber;
                            break;
                        }
                        else {
                            System.out.println("Wrong Mobile Number, Please try again\n");
                        }
                    }
                    while (true) {
                        String verify = mobileRegister.verify();
                        if (Objects.equals(verify, "Mobile Account verification successful. Proceed with registration.")) {
                            System.out.println(verify);
                            String finalUserName;
                            while (true) {
                                System.out.print("Enter a username: ");
                                String username = scanner.nextLine();
                                String unique = mobileRegister.checkUniqueBankUser(username);
                                if (unique.equals("AlreadyExists")) {
                                    System.out.println("Username is Already Exists please Try again");
                                } else {
                                    finalUserName = username;
                                    break;
                                }
                            }

                            System.out.print("Enter a password: ");
                            String password = scanner.nextLine();

                            mobileRegister.register(finalUserName, password, finalMobileNumber,generateRandomBalance());
                            break;
                        } else {
                            System.out.println("Wrong OTP");
                        }
                    }

                }
            }

            //Sign In Option
            else if(Objects.equals(choice , "2")){
                System.out.println("Enter your sign in Method : ");

                System.out.println("1- Bank user");
                System.out.println("2- Mobile user");
                String signInChoice = scanner.nextLine();

                System.out.println("Please Enter your UserName: ");
                String userName = scanner.nextLine();
                System.out.println("Please Enter your Password: ");
                String passWord = scanner.nextLine();

                if(Objects.equals(signInChoice, "1")){
                    int i = 0;
                    SignIn bankSignIn = new BankSignIn();
                    String verify = bankSignIn.signIn(userName , passWord);
                    if (Objects.equals(verify, "Bank User Signed In Successfully")){
                        System.out.println("\n" + verify);

                        for (i = 0 ; i < Users.ListOfBankUsers.size() ; i++){
                            if(Objects.equals(userName, Users.ListOfBankUsers.get(i).getUserName())) break;
                        }
                        System.out.println("Welcome, " + Users.ListOfBankUsers.get(i).getUserName());
                        System.out.println("Mobile Number: " + Users.ListOfBankUsers.get(i).getMobileNumber());
                        //Implement here what to do after signing in as a bank user
                       while (true){
                           char s = ConsoleMessage.transfer(i,'B');
                           if(s == 'a' || s == 'b' || s == 'c' || s == 'd'){
                               s = ConsoleMessage.transfer(i,'B');
                           }
                           else if(s == 'f'){
                               break;
                           }
                           else{
                               System.out.println("Wrong input, Please try again");
                           }
                       }
                    }
                    else System.out.println("Wrong User name OR password");
                }
                else if(Objects.equals(signInChoice, "2")){
                    int i = 0;
                    SignIn mobSignIn = new MobileSignIn();
                    String verify = mobSignIn.signIn(userName , passWord);
                    if (Objects.equals(verify, "Mobile user Signed In Successfully")){
                        System.out.println("\n" + verify);

                        for (i = 0 ; i < Users.ListOfMobileUsers.size() ; i++){
                            if(Objects.equals(userName, Users.ListOfMobileUsers.get(i).getUserName())) break;
                        }
                        System.out.println("Welcome, " + Users.ListOfMobileUsers.get(i).getUserName());
                        System.out.println("Mobile Number: " + Users.ListOfMobileUsers.get(i).getMobileNumber());
                        //Implement here what to do after signing in as a mobile user
                        while (true)
                        {
                            char s = ConsoleMessage.transfer(i,'M');
                            if(s == 'f'){
                                break;
                            }
                        }
                        //-------------------------------------------------

                    }
                    else System.out.println(verify);
                }
            }



            else if(Objects.equals(choice, "3")) {
                System.out.println("We are looking forward to seeing you soon :)");
              break;
            }
        }
    }
}