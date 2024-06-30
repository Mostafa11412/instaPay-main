import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import Controllers.*;

public class BankRegister implements Registration {




    @Override
    public void register(String userName, String pass , String mobileNumber , int balance) {
        Users NewUser = new Users(userName , pass , mobileNumber,balance);
        Controller.addBankUser(userName , pass , mobileNumber,balance);
        Controller.addToBankSet(userName);
        System.out.println("Bank user registered successfully!");
    }
    Scanner scanner = new Scanner(System.in);

    @Override
    public String verify() {
        System.out.println("Please Enter OTP message we sent: ");
        String otp = generateRandomString(10);
        System.out.println("This is OTP message, Please don't share it: " + otp);
        String verify = scanner.nextLine();
        if (Objects.equals(verify, otp)) {
            return "Bank Account verification successful. Proceed with registration.";
        }
        else{
            return "Wrong OTP";
        }
    }

    @Override
    public String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }
        return randomString.toString();
    }

    @Override
    public String checkUniqueBankUser(String username) {
        if(Users.setOfBankUsers.contains(username)){
            return "AlreadyExists";
        }
        else return "succss";
    }

}
