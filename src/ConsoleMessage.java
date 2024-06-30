import Bills.Bills;
import Bills.Gas;
import Bills.Water;
import Bills.Electricity;
import TransferPack.*;
import Controllers.*;
import java.util.Scanner;

public class ConsoleMessage {
    static Controller controller = new Controller();
    static Scanner scanner = new Scanner(System.in);
    public static char transfer(int  UserPos,char w)
    {
        int balance = controller.getUser_Balance(UserPos,w);
        System.out.println("\n----------------------------------");
        System.out.println("\nChoose your operation: ");
        System.out.println("a. Transfer to Wallet using the mobile number");
        System.out.println("b. Transfer to Another instapay account");
        if(w=='B')System.out.println("c. Transfer to Bank Account");
        System.out.println("d. Inquire about his balance");
        System.out.println("e. Pay bills");
        System.out.println("f. Log out");
        char transferChoice = scanner.next().charAt(0);
        scanner.nextLine();
        if(transferChoice == 'a') {
            System.out.println("Your balance :" + balance+ " $");
            System.out.print("Please Enter Amount of Money You Want to transfer : ");
            int Cost = Integer.parseInt(scanner.nextLine());
            if (Cost > balance)
            {
                System.out.println("Sorry You Dont Have Enough balance ");
            }
            else{
                System.out.println("Please Choose The Wallet Provider : ");
                System.out.println("1- Orange");
                System.out.println("2- Vodafone Cash");
                System.out.println("3- CIB");
                String providerChoice = scanner.nextLine();
                System.out.println("Please Enter Wallet Mobile number : ( Must be 11 numbers)");
                String number = scanner.nextLine();
                if(number.length() == 11 && number.matches("\\d+")) {
                    WalletProvider walletProvider = new NoWalletProvider();
                    if (providerChoice.equals("1")) {
                        walletProvider = new Orange();

                    } else if (providerChoice.equals("2")) {
                        walletProvider = new VodafoneCash();
                    } else if (providerChoice.equals("3")) {
                        walletProvider = new Cib();
                    } else {
                        System.out.println(" Invalid Choice");
                    }
                    Controller.Transfer(new TransferToWallet(UserPos, w, Cost, number, walletProvider));
                }
                else
                {
                    System.out.println("Wrong Number , please enter A valid one ");
                }
            }

            return 'a';
        }
        else if(transferChoice == 'b') {
            System.out.println("Your balance :" + balance+ " $");
            System.out.print("Please Enter Amount of Money You Want to transfer : ");
            int Cost = Integer.parseInt(scanner.nextLine());
            if (Cost > balance)
            {
                System.out.println("Sorry You Dont Have Enough balance ");
            }
            else {
                System.out.println("Please Enter InstaPay Id : (must be 5 numbers)");
                String instaPayID = scanner.nextLine();
                if (instaPayID.length() == 5 && instaPayID.matches("\\d+")) {
                    Controller.Transfer(new TransferToIstaPay(UserPos, w, Cost, instaPayID));
                } else {
                    System.out.println("Wrong Instapay Account Id, Please try again");
                }
            }
            return 'b';
        }
        else if(transferChoice == 'c'){
            System.out.println("Your balance :" + balance+ " $");
            System.out.print("Please Enter Amount of Money You Want to transfer : ");
            int Cost = Integer.parseInt(scanner.nextLine());
            if (Cost > balance)
            {
                System.out.println("Sorry You Dont Have Enough balance ");
            }
            else {
                System.out.println("Please enter Bank Account Id : (must be 11 numbers)");
                String BankId = scanner.nextLine();
                if (BankId.length() == 11 && BankId.matches("\\d+")) {
                    Controller.Transfer(new TransferToBank(UserPos, w, Cost, BankId));
                } else {
                    System.out.println("Wrong Bank Account Number, Please try again");
                }
            }

            return 'c';
        }
        else if(transferChoice == 'd')
        {

            System.out.print("Your Current Balance is : ");
            System.out.print(controller.getUser_Balance(UserPos,w) + "$\n");

            return 'd';
        }
        else if(transferChoice == 'e') {
                System.out.println("\nChoose Service : (Type 1 OR 2 Or 3)");
                System.out.println("1 - Gas");
                System.out.println("2 - Water");
                System.out.println("3 - Electricity\n");
                int c = scanner.nextInt();
                if (c == 1) {
                    Bills b = new Gas();
                    b.Pay_Bill(UserPos,w);
                } else if (c == 2) {
                    Bills b = new Water();
                    b.Pay_Bill(UserPos,w);
                } else if (c == 3) {
                    Bills b = new Electricity();
                    b.Pay_Bill(UserPos,w);
                } else {
                    System.out.println("please Enter A valid Choice \n");
                }
                return 'e';
        }
        else if(transferChoice == 'f') return 'f';
        else return '0';
    }
}
